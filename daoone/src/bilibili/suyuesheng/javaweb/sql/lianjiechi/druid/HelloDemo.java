package bilibili.suyuesheng.javaweb.sql.lianjiechi.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Properties;

/**
 * druid 第一次使用
 * @author 苏月晟
 */
public class HelloDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");
        Properties pro = new Properties();
        InputStream ii = HelloDemo.class.getResourceAsStream("/druid.properties");
//        byte cc[] = new byte[2048];
//        int b = 0;
//        int len =0;
//        while((b=ii.read())!=-1){
//            cc[len]=(byte)b;
//            len++;
//        }
//        System.out.println(len);
//        System.out.println(new String(cc,0,len));
//        //        pro.load(ii);
        pro.load(ii);
        //获取连接对象
        DataSource dd = DruidDataSourceFactory.createDataSource(pro);
        Connection cdd = dd.getConnection();
        cdd.close();
    }
}
