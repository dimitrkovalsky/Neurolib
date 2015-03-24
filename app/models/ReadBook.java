package models;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import relations.Relations;
import utils.Rating;

/**
 * User: Maxxis
 * Date: 24.03.2015
 * Time: 19:48
 */
@NodeEntity
public class ReadBook {
    @GraphId
    private Long id;
    @RelatedTo(direction = Direction.OUTGOING, type = Relations.READ)
    private Book book;

    private Rating rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
