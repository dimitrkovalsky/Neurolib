package reco;

import com.graphaware.reco.generic.post.PostProcessor;
import com.graphaware.reco.generic.result.Recommendation;
import com.graphaware.reco.generic.result.Recommendations;
import models.Author;
import models.Book;
import models.Genre;

/**
 * User: dimitr
 * Date: 15.03.2015
 * Time: 10:29
 */
public class RewardSameAuthorAndGenre implements PostProcessor<Book, Book> {

    @Override
    public void postProcess(Recommendations<Book> recommendations, Book input) {
        Author inputAuthor = input.getAuthor();
        Genre inputGenre = input.getGenre();
        for (Recommendation<Book> recommendation : recommendations.get()) {
            if (recommendation.getItem().getAuthor().equals(inputAuthor) && recommendation.getItem().getGenre().equals(inputGenre))
                recommendation.add("sameAuthorAndGenre", 10);
        }
    }
}
