package club.suyuesheng.factory;

import club.suyuesheng.dao.IDepartmentsDAO;
import club.suyuesheng.dao.IEmployeesDAO;
import club.suyuesheng.dao.impl.DepartmentsDAOImpl;
import club.suyuesheng.dao.impl.EmployeesDAOImpl;

import java.sql.Connection;

/**
 * 工厂类，获得接口实现的类的实例化对象
 * @author 苏月晟
 */
public class DAOFactory {
    /**
     * 获得雇员接口的实例化对象
     * @param connection 数据库的连接
     * @return 返回雇员接口的实现类 EmployeesDAOImpl
     */
    public static IEmployeesDAO getIEmployeesDAOInstance(Connection connection){
        return new EmployeesDAOImpl(connection);
    }

    /**
     *
     * @param connection
     * @return
     */
    public static IDepartmentsDAO getIDepartmentsDAOInstance(Connection connection){
        return new DepartmentsDAOImpl(connection);
    }
}
