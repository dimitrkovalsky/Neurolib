package services;

import models.Author;
import models.Book;
import models.Genre;
import models.UserProfile;
import repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 12:41
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllAuthorBooks(Author author) {
        String lastName = author.getLastName();
        if (lastName != null)
            return bookRepository.findAllByAuthorLastName(lastName);
        else
            return bookRepository.findAllByAuthorId(author.getId());
    }

    public Book getBook(long id) {
        return bookRepository.findOne(id);
    }

    public Book getBook(String name) {
        return bookRepository.findOneByName(name);
    }

    public List<Book> getTopBooks() {
        return null;
    }

    public List<Book> getTopBooksByAuthor(Author author) {
        return null;
    }

    public List<Book> getTopBooksByGenre(List<Genre> favoriteGenres) {
        return null;
    }

    public List<Book> getTopFriendsBooks(List<UserProfile> friends) {
        return null;
    }

    public List<Book> getTopBooksByAuthors(List<Author> favoriteAuthors) {
        Iterator<List<Book>> authorBooks = favoriteAuthors.stream().map(this::getTopBooksByAuthor).iterator();
        return null;
    }
}
