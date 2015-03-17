package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.Result;
import services.GenreService;
import views.html.genres;

@org.springframework.stereotype.Controller
public class Application {
    @Autowired
    private GenreService genreService;

    public Result index() {
        return play.mvc.Controller.ok(genres.render(genreService.getAllGenres()));
    }



}
