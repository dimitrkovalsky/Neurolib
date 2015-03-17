package repositories;

import models.Genre;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 12:39
 */
public interface GenreRepository extends GraphRepository<Genre> {
    public Genre findOneByName(String name);
}
