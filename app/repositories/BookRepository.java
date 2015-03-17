package repositories;

import models.Book;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 12:40
 */
public interface BookRepository extends GraphRepository<Book> {
    @Query("MATCH (b:Book)-->({lastName: {0}}) RETURN b")
    public List<Book> findAllByAuthorLastName(String lastName);

    @Query("MATCH (b:Book)-->(a) where id(a) = {0} RETURN b")
    public List<Book> findAllByAuthorId(Long id);

    Book findOneByName(String name);
}
