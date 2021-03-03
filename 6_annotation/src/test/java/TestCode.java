import com.qiuhui.projo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCode {
    @Test
    public void testSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // getBean(name),名字为类名的大小写，否则报错
        User user = (User) context.getBean("user");
        System.out.println(user.name);
        System.out.println(user.getAge());
    }
}
