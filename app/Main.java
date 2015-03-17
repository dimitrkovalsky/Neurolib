import com.graphaware.reco.generic.context.Mode;
import com.graphaware.reco.generic.result.Recommendation;
import models.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import reco.BookRecommendationEngine;
import services.AuthorService;
import services.BookService;
import services.GenreService;

import java.util.List;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 14:55
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        GenreService genreService = context.getBean(GenreService.class);
        AuthorService authorService = context.getBean(AuthorService.class);
        BookService bookService = context.getBean(BookService.class);

        Book book = bookService.getBook("Humoreskus");
        System.out.println(book);

        BookRecommendationEngine engine = new BookRecommendationEngine();
        List<Recommendation<Book>> recommend = engine.recommend(book, Mode.REAL_TIME, 2);
        for (Recommendation<Book> bookRecommendation : recommend) {
            System.out.println("Score : " + bookRecommendation.getScore().getTotalScore() + "\t" + bookRecommendation.getItem());
        }

    }
}
