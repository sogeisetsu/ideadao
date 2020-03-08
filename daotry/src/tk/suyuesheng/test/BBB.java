package tk.suyuesheng.test;

import org.springframework.jdbc.core.JdbcTemplate;
import tk.suyuesheng.dbc.DatabaseConnection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * 实验 tk.suyuesheng.dbc.DatabaseConnection;
 */
public class BBB {
    public static void main(String[] args) {
        JdbcTemplate template= DatabaseConnection.getTemplate();
        String sql = "SELECT emp_no FROM employees WHERE emp_no= 1";
        Map<String,Object> map = template.queryForMap(sql);
        System.out.println(map);
        Collection<Object> oo = map.values();
        Iterator<Object> iterator = oo.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
