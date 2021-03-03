import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class People {
    /**
     * 注解方式可以省略setter
     * @Autowired(required = false)  属性为空，也不会报错
     * Qualifier指定 bean id名称
     * @Resource也可以指定name, @Resource(name="car")
     */
    @Autowired
    private Car car;

    @Resource
    private MiniCar miniCar;

    @Autowired
    @Qualifier(value = "a22222")
    private BusinessCar businessCar;

    public String name;

    public BusinessCar getBusinessCar() {
        return businessCar;
    }

    public Car getCar() {
        return car;
    }

    public MiniCar getMiniCar() {
        return miniCar;
    }

    public String getName() {
        return name;
    }
}
