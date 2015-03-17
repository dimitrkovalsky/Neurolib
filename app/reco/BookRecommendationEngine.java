package reco;

import com.graphaware.reco.generic.engine.RecommendationEngine;
import com.graphaware.reco.generic.engine.TopLevelDelegatingRecommendationEngine;
import com.graphaware.reco.generic.log.Logger;
import com.graphaware.reco.generic.log.Slf4jRecommendationLogger;
import com.graphaware.reco.generic.log.Slf4jStatisticsLogger;
import com.graphaware.reco.generic.post.PostProcessor;
import models.Book;

import java.util.Arrays;
import java.util.List;

/**
 * User: dimitr
 * Date: 15.03.2015
 * Time: 13:19
 */
public class BookRecommendationEngine extends TopLevelDelegatingRecommendationEngine<Book, Book> {

    public BookRecommendationEngine() {
        super(new BooksContextFactory());
    }


    @Override
    protected List<Logger<Book, Book>> loggers() {
        return Arrays.asList(
                new Slf4jRecommendationLogger<Book, Book>(),
                new Slf4jStatisticsLogger<Book, Book>()
        );
    }

    @Override
    protected List<RecommendationEngine<Book, Book>> engines() {
        return Arrays.<RecommendationEngine<Book, Book>>asList(
                new SameAuthorEngine());
    }

    @Override
    protected List<PostProcessor<Book, Book>> postProcessors() {
        return Arrays.<PostProcessor<Book, Book>>asList(new RewardSameAuthor(),
                new RewardSameGenre(), new RewardSameAuthorAndGenre());
    }
}