package services;

import models.Author;
import repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 12:46
 */
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void save(Author author) {
        authorRepository.save(author);
    }

    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(long id) {
        return authorRepository.findOne(id);
    }

    public Author getAuthor(String name) {
        return authorRepository.findOneByLastName(name);
    }
}
