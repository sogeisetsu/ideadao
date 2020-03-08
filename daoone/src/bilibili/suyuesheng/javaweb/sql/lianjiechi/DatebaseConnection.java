package bilibili.suyuesheng.javaweb.sql.lianjiechi;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 连接数据库的操作
 * @author 苏月晟
 */
public class DatebaseConnection {
    public static DataSource dataSource;
    private static Connection connection;
    static {//自动设置数据库连接池
        Properties pro = new Properties();
        try {
            pro.load(DatebaseConnection.class.getResourceAsStream("/druid.properties"));
            dataSource=DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得数据库连接实例对象，这个实例对象是从连接池里面取得的
     * @return 数据库连接实例对象 Connection
     */
    public static Connection getConnection(){
        try {
          connection=dataSource.getConnection();
          return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 归还数据库连接
     */
    public static void close(){
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 归还数据库的连接的同时，关闭Statement实例对象
     * @param stat Statement的实例对象
     */
    public static void close(Statement stat){
        try{
            if(stat!=null){
                stat.close();//关闭对数据库的操作
            }
            close();//调用无参方法
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
