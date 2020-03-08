package bilibili.suyuesheng.javaweb.sql.lianjiechi.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 第一次接触数据库连接池
 *
 * @author 苏月晟
 */
/*创建数据库连接是一个很耗时的操作，也容易对数据库造成安全隐患。
* 所以，在程序初始化的时候，集中创建多个数据库连接，并把他们集中管理，
* 供程序使用，可以保证较快的数据库读写速度，还更加安全可靠。
* */
public class HelloDemo {
    public static void main(String[] args) throws SQLException {
        long stsrt = System.currentTimeMillis();
        System.out.println("hello world");
        //创建数据库连接对象
        DataSource dd = new ComboPooledDataSource();
        //获取数据库连接
        Connection dc = dd.getConnection();
        //打印
        System.out.println(dc);
        dc.close();
        for(int i=1;i<=12;i++){
            Connection con = dd.getConnection();
            System.out.println(i+"\t"+con);
            if((String.valueOf(i).charAt(String.valueOf(i).length()-1)=='1')|| String.valueOf(i).charAt(String.valueOf(i).length()-1)=='2'){
                con.close();//归还数据库连接
            }
        }
//        DataSource ds = new ComboPooledDataSource();
//        for(int i=1;i<=12;i++){
//            Connection con = ds.getConnection();
//            System.out.println(i+"\t"+con);
//            if(String.valueOf(i).charAt(String.valueOf(i).length()-1)=='1'){
//                con.close();//归还数据库连接
//            }
//        }
        long end = System.currentTimeMillis();
        System.out.println("程序运行" + (end - stsrt) + "毫秒");

    }
}
