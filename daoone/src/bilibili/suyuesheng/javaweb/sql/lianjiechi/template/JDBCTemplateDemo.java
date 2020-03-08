package bilibili.suyuesheng.javaweb.sql.lianjiechi.template;

import bilibili.suyuesheng.javaweb.sql.lianjiechi.DatebaseConnection;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class JDBCTemplateDemo {
    public static void main(String[] args) throws SQLException, ParseException {
//        Properties pro = new Properties();
//        try {
//            pro.load(JDBCTemplateDemo.class.getResourceAsStream("/druid.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        DataSource cc = null;
//        try {
//             cc = DruidDataSourceFactory.createDataSource(pro);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Connection con = cc.getConnection();
        DataSource ss = DatebaseConnection.dataSource;
        JdbcTemplate template = new JdbcTemplate(ss);
        //修改
        String sql = "UPDATE employees SET first_name='赵' where first_name=?";
        int count = template.update(sql, "lulu");
        System.out.println(count);
        //连接的归还由spring完成
        //增
//        String sqll = "INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date) " +
//                " VALUES(?,?,?,?,?,?)";
//        SimpleDateFormat smft = new SimpleDateFormat("yyyy-MM-dd");
//        int ccount = template.update(sqll, 120,smft.parse("1975-09-09"),"流ll","海mmm","M",smft.parse("2020-02-07"));
//        System.out.println(ccount);
        //删
        sql = "DELETE FROM employees WHERE emp_no=?";
        count = template.update(sql, 123);
        System.out.println(count);
        //查
        //这个只能查一条记录
        sql = "SELECT * FROM employees WHERE emp_no=?";
        Map<String,Object> map = template.queryForMap(sql, 125);
        System.out.println(map);
        Set<Map.Entry<String,Object>> mapset = map.entrySet();
        Iterator<Map.Entry<String,Object>> imap = mapset.iterator();
        Employees employees =new Employees();
        while(imap.hasNext()){
            Map.Entry<String,Object> ml = imap.next();
            switch (ml.getKey()){
                case "emp_no":{
                    employees.setEmpno((Integer)ml.getValue());
                    break;
                }
                case "birth_date":{
                    employees.setBirthdate((Date)ml.getValue());
                    break;
                }
                case "first_name":{
                    employees.setFirstname((String)ml.getValue());
                    break;
                }
                default:{
                    System.out.println("跳出循环");
                    break;
                }
            }
        }
        System.out.println(employees);
        System.out.println(">-------------------------");
        sql = "SELECT * FROM employees WHERE birth_date BETWEEN ? AND ? LIMIT 100";
        List<Map<String,Object>> mapList = template.queryForList(sql,"1945-09-09","1972-01-09");
        for(Map<String,Object> mlm :mapList){
            System.out.println(mlm.toString());
        }
        System.out.println("2-------------------------");
        sql = "SELECT * FROM employees WHERE birth_date BETWEEN ? AND ? LIMIT 100";
        List<Employees> lemp = template.query(sql, new RowMapper<Employees>() {
            @Override
            public Employees mapRow(ResultSet resultSet, int i) throws SQLException {
                Employees emp = new Employees();
                emp.setEmpno(resultSet.getInt(1));
                emp.setBirthdate(resultSet.getDate(2));
                emp.setFirstname(resultSet.getString(3));
                emp.setLastname(resultSet.getString(4));
                emp.setGender(resultSet.getString(5));
                emp.setHiredate(resultSet.getDate(6));
                return emp;
            }
        }, "1945-09-09", "1976-09-09");
        for(Employees emp:lemp){
            System.out.println(emp);
        }
    }
    @Test
    public void test(){
        System.out.println("hello World");
    }
    @Test
    public void test1(){
        JdbcTemplate template = new JdbcTemplate(DatebaseConnection.dataSource);
        String sql = "SELECT COUNT(*) FROM employees WHERE first_name LIKE ?";
        Integer count=template.queryForObject(sql, Integer.class, "%"+"lu"+"%");
        System.out.println(count);
    }
}
