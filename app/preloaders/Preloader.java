package preloaders;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 12:48
 */
public abstract class Preloader {
    public void load() {
        System.out.println("preloaders.Preloader " + name() + " started");
        long start = System.currentTimeMillis();
        int count = preLoad();
        System.out.println(count + " entities loaded in " + (System.currentTimeMillis() - start) + " millis");
    }

    public abstract int preLoad();

    public abstract String name();
}
