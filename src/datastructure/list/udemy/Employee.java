package datastructure.list.udemy;

import java.util.Objects;

public class Employee {
    private final String fullName;
    private final int number;

    public Employee(String fullName, int number) {
        this.fullName = fullName;
        this.number = number;
    }

    public String getFullName() {
        return fullName;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return number == employee.number && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, number);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", number=" + number +
                '}';
    }
}
