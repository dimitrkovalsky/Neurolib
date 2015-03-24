package services;

import models.Author;
import models.Genre;
import models.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Maxxis
 * Date: 24.03.2015
 * Time: 20:02
 */
@Service
public class UserService {
    /**
     * Should return empty list if authors are not exists
     * @param profile
     * @return
     */
    public List<Author> getFavoriteAuthors(UserProfile profile) {
        return null;
    }

    public List<UserProfile> getFriends(UserProfile profile) {
        return null;
    }

    public List<Genre> getFavoriteGenres(UserProfile profile) {
        return null;
    }
}
