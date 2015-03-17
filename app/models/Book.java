package models;

import relations.Relations;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * User: Dmytro_Kovalskyi
 * Date: 12.03.2015
 * Time: 16:39
 */
@NodeEntity
public class Book {
    @GraphId
    private Long id;
    private String name;
    private String isbn;
    private int year;
    private String link;

    @RelatedTo(direction = Direction.OUTGOING, type = Relations.GENRE)
    @Fetch
    private Genre genre;
    @RelatedTo(direction = Direction.OUTGOING, type = Relations.WRITTEN)
    @Fetch
    private Author author;

    public Book() {
    }

    public Book(String name, Genre genre, Author author) {
        this.name = name;
        this.genre = genre;
        this.author = author;
    }

    public Book(String name, int year, Genre genre, Author author) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year=" + year +
                ", link='" + link + '\'' +
                ", genre=" + genre +
                ", author=" + author +
                '}';
    }
}
