package datastructure.algorithms.plainjava.jdbc;


import datastructure.algorithms.plainjava.jdbc.domain.Person;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/juju";
    private static final String USER = "giri";
    private static final String PASSWORD = "giri";

    private static final String DDL_CREATE = "CREATE TABLE IF NOT EXISTS person (\n" +
            "    id BIGSERIAL PRIMARY KEY,\n" +
            "    first_name VARCHAR(50) NOT NULL,\n" +
            "    last_name VARCHAR(50) NOT NULL,\n" +
            "    last_modified_at TIMESTAMPTZ DEFAULT NOW(),\n" +
            "    created_at TIMESTAMPTZ DEFAULT NOW()\n" +
            ");";

    public static void main(String[] args)  {
        List<Person> people = makeRandom();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("connection 성공");
            ddl(connection);
            System.out.println("start statement Batch");
            for (var i = 0; i < 10; i++) {
                batchInsertWithStatement(people, connection);
            }

            System.out.println("start preparedStatement Batch");
            for (var i = 0; i < 10; i++) {
                batchInsertWithPreparedStatement(people, connection);
            }

            List<Person> all = findAll(connection);
            System.out.println("people size : " + all.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Person> findAll(final Connection connection) throws SQLException {
        var ps = connection.prepareStatement("SELECT id, first_name, last_name, last_modified_at, created_at FROM person");
        var rs = ps.executeQuery();
        var people = new LinkedList<Person>();
        while (rs.next()) {
            long id = rs.getLong("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String lastModifiedAt = rs.getString("last_modified_at").substring(0, 19);
            String createdAt = rs.getString("created_at").substring(0, 19);
            people.add(new Person(id, firstName, lastName, lastModifiedAt, createdAt));
        }

        return people;
    }

    private static void batchInsertWithPreparedStatement(List<Person> people, Connection connection) throws SQLException {
        long start = System.currentTimeMillis();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person(first_name, last_name) VALUES(?,?)");
        for (var person : people) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
        System.out.println("duration : " + (System.currentTimeMillis() - start));
    }

    private static void batchInsertWithStatement(List<Person> people, Connection connection) throws SQLException {
        long start = System.currentTimeMillis();
        Statement statement = connection.createStatement();
        for (var person : people) {
            statement.addBatch("INSERT INTO person(first_name, last_name) VALUES('"+ person.getFirstName() + "','" + person.getLastName() + "')");
        }

        statement.executeBatch();
        System.out.println("duration : " + (System.currentTimeMillis() - start));
    }

    private static List<Person> makeRandom() {
        int i = 0;
        List<Person> persons = new LinkedList<>();
        while (i < 1000) {
            String name = UUID.randomUUID().toString();
            int mid = name.length() / 2;
            persons.add(new Person(name.substring(0, mid), name.substring(mid)));
            i++;
        }

        return persons;
    }

    private static void ddl(final Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(DDL_CREATE);
    }
}
