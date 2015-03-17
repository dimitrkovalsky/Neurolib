package reco;

import com.graphaware.reco.generic.post.PostProcessor;
import com.graphaware.reco.generic.result.Recommendation;
import com.graphaware.reco.generic.result.Recommendations;
import models.Author;
import models.Book;

/**
 * User: dimitr
 * Date: 15.03.2015
 * Time: 10:29
 */
public class RewardSameAuthor implements PostProcessor<Book, Book> {

    @Override
    public void postProcess(Recommendations<Book> recommendations, Book input) {
        Author inputAuthor = input.getAuthor();
        for (Recommendation<Book> recommendation : recommendations.get()) {
            if (recommendation.getItem().getAuthor().equals(inputAuthor))
                recommendation.add("sameAuthor", 20);
        }
    }
}