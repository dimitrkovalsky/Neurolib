package preloaders;

import models.Author;
import services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 15:11
 */
@Service
public class AuthorPreloader extends Preloader {


    @Autowired
    private AuthorService authorService;

    @Override
    public int preLoad() {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Robert", "Heinlein"));
        authors.add(new Author("George", "Oruell"));
        authors.add(new Author("Aldous", "Huxley"));
        authors.add(new Author("Ray", "Bradbury"));

        authors.forEach(authorService::save);
        return authors.size();
    }

    @Override
    public String name() {
        return "preloaders.AuthorPreloader";
    }

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
}
