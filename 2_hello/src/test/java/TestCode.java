import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCode {
    public static void main(String[] args) {
        /**
         * org.springframework.context.ApplicationContext接口代表 Spring IoC 容器，并负责实例化，配置和组装 Bean
         * 以下是实例化容器,获取spring上下文对象
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object hello = context.getBean("hello");
        System.out.println(hello.toString());
    }
}
