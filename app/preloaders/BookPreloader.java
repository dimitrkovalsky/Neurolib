package preloaders;

import models.Author;
import models.Book;
import models.Genre;
import services.AuthorService;
import services.BookService;
import services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 16:40
 */
@Service
public class BookPreloader extends Preloader {
    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private AuthorService authorService;

    @Override
    public int preLoad() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Door to summer", 1962, genre("Fiction"), author("Heinlein")));
        books.add(new Book("1984", 1957, genre("Fiction"), author("Oruell")));
        books.add(new Book("451 pharenheit", 1978, genre("Fiction"), author("Bradbury")));
        books.add(new Book("Something dramatic", 2005, genre("Drama"), author("Huxley")));
        books.add(new Book("Humoreskus", 2005, genre("Humor"), author("Huxley")));
        books.add(new Book("Kobzar in new world", 2001, genre("Poetry"), author("Bradbury")));
        books.forEach(bookService::save);
        return books.size();
    }

    private Genre genre(String name) {
        return genreService.getGenre(name);
    }

    private Author author(String name) {
        return authorService.getAuthor(name);
    }

    @Override
    public String name() {
        return "preloaders.BookPreloader";
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
}
