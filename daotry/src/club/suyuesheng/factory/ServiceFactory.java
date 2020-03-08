package club.suyuesheng.factory;

import club.suyuesheng.service.IEmployeesService;
import club.suyuesheng.service.impl.EmployeesServiceImpl;

/**
 * 业务层工厂类 获得业务层接口实现类的实例化对象
 * @author 苏月晟
 */
public class ServiceFactory {
    /**
     * 获得雇员业务层接口实现类的实例化对象
     * @return 返回雇员业务层接口实现类的实例化对象 EmployeesServiceImpl()
     */
    public static IEmployeesService getEmployeesServiceInstance(){
        return new EmployeesServiceImpl();
    }
}
