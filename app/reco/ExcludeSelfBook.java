package reco;

import com.graphaware.reco.generic.filter.BlacklistBuilder;
import com.graphaware.reco.generic.filter.Filter;
import models.Book;

import java.util.Collections;
import java.util.Set;

import static org.springframework.util.Assert.notNull;

/**
 * User: dimitr
 * Date: 15.03.2015
 * Time: 13:44
 */
public class ExcludeSelfBook implements Filter<Book, Book>, BlacklistBuilder<Book,Book> {
    @Override
    public boolean include(Book item, Book input) {
        notNull(item);
        notNull(input);

        return input.getId() != item.getId();
    }

    @Override
    public Set<Book> buildBlacklist(Book input) {
        notNull(input);
        return Collections.singleton(input);
    }
}
