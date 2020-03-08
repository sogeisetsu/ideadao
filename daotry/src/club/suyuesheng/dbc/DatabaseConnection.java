package club.suyuesheng.dbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 本类负责数据库的连接与关闭
 * @author 苏月晟
 */
public class DatabaseConnection {
    private static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3307/employees?characterEncoding=utf-8";
    private static final String DBUSER="root";
    private static final String DBPAS="su15990904343";
    private Connection con;

    /**
     * 构造方法进行数据库连接
     */
    public DatabaseConnection(){
        try {
            DataSource dd = new ComboPooledDataSource();
            this.con=dd.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接到数据库的实例化对象
     * @return Connection 接口对象
     */
    public Connection getConnection(){
        return this.con;
    }

    /**
     * 关闭连接，就算，就算没有链接上，close方法也不会出错
     */
    public void close(){
        if(this.con!=null){
            try {
                this.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("兄弟，你没链接上！！！\n可别整这没用的了！哦！！！");
        }
    }
}
