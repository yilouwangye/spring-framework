import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCode {
    public static void main(String[] args) {

        // applicationContext.xml通过Import 导入各个beans文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        /**
         * 活跃用户数量：500万
         * Vip无参数构造
         */
    }
}
