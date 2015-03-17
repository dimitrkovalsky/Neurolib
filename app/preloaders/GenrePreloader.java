package preloaders;

import models.Genre;
import services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 12:50
 */
@Service
public class GenrePreloader extends Preloader {
    @Autowired
    private GenreService genreService;

    @Override
    public int preLoad() {
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre("Fiction"));
        genres.add(new Genre("Humor"));
        genres.add(new Genre("Drama"));
        genres.add(new Genre("Poetry"));
        genres.forEach(genreService::save);
        return genres.size();
    }

    @Override
    public String name() {
        return "preloaders.GenrePreloader";
    }

    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }
}
