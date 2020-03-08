package tk.suyuesheng.dbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection con;
    private static DataSource dataSource;
    private static JdbcTemplate template;
    static {
        Properties pro = new Properties();
        try {
            pro.load(DatabaseConnection.class.getResourceAsStream("/druid.properties"));
            dataSource= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnnection(){
        try {
            con=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static JdbcTemplate getTemplate(){
        template = new JdbcTemplate(dataSource);
        return template;
    }
    public static void close(){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
