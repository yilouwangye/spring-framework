import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TestCode {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Students students = (Students) context.getBean("name");
        System.out.println(students.getName());
        System.out.println(students.getLikes());
        System.out.println(students.getGames());
        System.out.println(students.getScore());
        System.out.println(students.getSkills());
        System.out.println(students.getAge());
        System.out.println(students.getInfo());
    }
    @Test
    public void testmodule(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user",User.class);
        System.out.println(user);

        User user1 = context.getBean("user1",User.class);
        System.out.println(user1);
    }
}
