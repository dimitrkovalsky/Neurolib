package models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.util.List;

/**
 * User: Maxxis
 * Date: 24.03.2015
 * Time: 19:43
 */
@NodeEntity
public class UserProfile {
    @GraphId
    private Long id;
    private List<ReadBook> readBooks;
    private List<ReadBook> nowReading;
    private List<User> friends;
    // Authors that  were chosen by user manually
    private List<Author> favoriteAuthors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<ReadBook> getReadBooks() {
        return readBooks;
    }

    public void setReadBooks(List<ReadBook> readBooks) {
        this.readBooks = readBooks;
    }

    public List<ReadBook> getNowReading() {
        return nowReading;
    }

    public void setNowReading(List<ReadBook> nowReading) {
        this.nowReading = nowReading;
    }

    public List<Author> getFavoriteAuthors() {
        return favoriteAuthors;
    }

    public void setFavoriteAuthors(List<Author> favoriteAuthors) {
        this.favoriteAuthors = favoriteAuthors;
    }
}
