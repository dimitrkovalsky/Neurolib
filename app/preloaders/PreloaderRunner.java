package preloaders;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 13:04
 */
public class PreloaderRunner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        List<Preloader> preloaders = new ArrayList<>();
        preloaders.add(context.getBean(GenrePreloader.class));
        preloaders.add(context.getBean(AuthorPreloader.class));
        preloaders.add(context.getBean(BookPreloader.class));
        preloaders.forEach(Preloader::load);
    }
}
