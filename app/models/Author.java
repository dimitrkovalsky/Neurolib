package models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * User: Dmytro_Kovalskyi
 * Date: 12.03.2015
 * Time: 16:36
 */
@NodeEntity
public class Author {
    @GraphId
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;


    public Author() {
    }

    public Author(Long id) {
        this.id = id;
    }

    public Author(String lastName) {
        this.lastName = lastName;
    }

    public Author( String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Author(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (firstName != null ? !firstName.equals(author.firstName) : author.firstName != null) return false;
        if (lastName != null ? !lastName.equals(author.lastName) : author.lastName != null) return false;
        if (middleName != null ? !middleName.equals(author.middleName) : author.middleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        return result;
    }
}
