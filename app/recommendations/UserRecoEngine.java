package recommendations;

import com.graphaware.reco.generic.context.Context;
import com.graphaware.reco.generic.engine.SingleScoreRecommendationEngine;
import models.Author;
import models.Book;
import models.Genre;
import models.UserProfile;
import services.BookService;
import services.UserService;
import utils.ServiceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Maxxis
 * Date: 24.03.2015
 * Time: 19:57
 */
public class UserRecoEngine extends SingleScoreRecommendationEngine<Book, UserProfile> {
    private static final int THRESHOLD = 100;
    private UserService userService = ServiceFactory.getUserService();
    private BookService bookService = ServiceFactory.getBookService();

    @Override
    protected Map<Book, Float> doRecommendSingle(UserProfile profile, Context<Book, UserProfile> context) {
        Map<Book, Float> result = new HashMap<>();
        List<Author> favoriteAuthors = userService.getFavoriteAuthors(profile);
        List<UserProfile> friends = userService.getFriends(profile);
        List<Genre> favoriteGenres = userService.getFavoriteGenres(profile);

        //TODO: Friend's top
        List<Book> topFriendsBooks = bookService.getTopFriendsBooks(friends);
        topFriendsBooks.forEach(b -> addToResult(result, b, 1));

        if (result.size() < THRESHOLD) {
            //TODO: If User likes some author then their book will be in top
            List<Book> topBooksByAuthor = bookService.getTopBooksByAuthors(favoriteAuthors);
            topBooksByAuthor.forEach(b -> addToResult(result, b, 1));
        }

        if (result.size() < THRESHOLD) {
            //TODO: If User likes some genre then return top books by this genre
            List<Book> topBooksByGenre = bookService.getTopBooksByGenre(favoriteGenres);
            topBooksByGenre.forEach(b -> addToResult(result, b, 1));
        }

        if (result.size() < THRESHOLD) {
            //TODO: Common top
            List<Book> topBooks = bookService.getTopBooks();
            topBooks.forEach(b -> addToResult(result, b, 1));
        }

        return result;
    }

    @Override
    public String name() {
        return "UserRecommendationEngine";
    }
}
