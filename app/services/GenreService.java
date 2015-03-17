package services;

import models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.GenreRepository;

import java.util.List;

import static org.neo4j.helpers.collection.Iterables.toList;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 12:44
 */
@Service
public class GenreService  {
    @Autowired
    private GenreRepository genreRepository;

    // TODO: throw exception if null
    public Genre getGenre(long id) {
        return genreRepository.findOne(id);
    }

    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    public List<Genre> getAllGenres() {
        return toList(genreRepository.findAll());
    }

    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre getGenre(String name) {
        return genreRepository.findOneByName(name);
    }
}
