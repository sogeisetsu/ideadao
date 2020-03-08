package bilibili.suyuesheng.javaweb.sql.lianjiechi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试Druid工具类
 * @author 苏月晟
 */
public class ASD {
    public static void main(String[] args) throws SQLException {
        Connection cc = DatebaseConnection.getConnection();
        String sql="SELECT * FROM employees";
        PreparedStatement ss = cc.prepareStatement(sql);
        DatebaseConnection.close(ss);
    }
}
