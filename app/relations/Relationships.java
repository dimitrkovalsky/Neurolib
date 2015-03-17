package relations;

import org.neo4j.graphdb.RelationshipType;

/**
 * User: Dmytro_Kovalskyi
 * Date: 12.03.2015
 * Time: 16:27
 */
public enum Relationships implements RelationshipType {
    WRITTEN, READ, LIKE_AUTHOR;

    public static void main(String[] args) {

    }
}
