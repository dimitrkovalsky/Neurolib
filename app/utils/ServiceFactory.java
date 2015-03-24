package utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.BookService;
import services.UserService;

/**
 * User: dimitr
 * Date: 15.03.2015
 * Time: 13:33
 */
public class ServiceFactory {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

    private static BookService bookService = context.getBean(BookService.class);

    private static UserService userService = context.getBean(UserService.class);

    public static BookService getBookService() {
        return bookService;
    }
    public static UserService getUserService() {
        return userService;
    }

}
