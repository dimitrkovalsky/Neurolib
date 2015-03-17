package reco;

import com.graphaware.reco.generic.context.FilteringContextFactory;
import com.graphaware.reco.generic.filter.Filter;
import models.Book;

import java.util.Arrays;
import java.util.List;

/**
 * User: dimitr
 * Date: 15.03.2015
 * Time: 13:17
 */
public class BooksContextFactory extends FilteringContextFactory<Book, Book> {
    @Override
    protected List<Filter<Book, Book>> filters() {
        return Arrays.<Filter<Book, Book>>asList(
                new ExcludeSelfBook()
        );
    }
}
