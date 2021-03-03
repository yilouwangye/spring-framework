import com.qiuhui.dao.UserDaoImpl;
import com.qiuhui.dao.UserDaoMysql;
import com.qiuhui.service.UserService;
import com.qiuhui.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        /**
         * 方法一
         *设置类为变量
         */
//        UserService userService = new UserServiceImpl();
//        ((UserServiceImpl)userService).setUserDao(new UserDaoImpl());
//        userService.getUser();
        /**
         * 方法二
         * 利用spring创建、管理、装配
         *
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");   // alt + 回车，创建对象
        UserServiceImpl userDao = (UserServiceImpl) context.getBean("UserService");
        userDao.getUser();
    }

}
