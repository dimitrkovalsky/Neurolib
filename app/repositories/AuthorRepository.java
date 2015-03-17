package repositories;

import models.Author;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 12:39
 */
public interface AuthorRepository extends GraphRepository<Author> {
    public Author findOneByLastName(String lastName);
}
