package bilibili.suyuesheng.javaweb.sql.lianjiechi.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo {
    public static void main(String[] args) throws SQLException {
        DataSource dd = new ComboPooledDataSource();
        Connection cc = dd.getConnection();
        }
    }

