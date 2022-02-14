package plainjava.jdbc.domain;

import net.sf.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person {
    private Long id;
    private final String firstName;
    private final String lastName;
    private LocalDateTime lastModifiedAt;
    private LocalDateTime createdAt;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(Long id, String firstName, String lastName, String lastModifiedAt, String createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastModifiedAt = LocalDateTime.parse(lastModifiedAt, DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss"));
        this.createdAt = LocalDateTime.parse(createdAt, DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss"));
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastModifiedAt=" + lastModifiedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
