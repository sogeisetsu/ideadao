import club.suyuesheng.factory.ServiceFactory;
import club.suyuesheng.vo.Employees;

import java.util.Iterator;
import java.util.List;

public class AAA {
    public static void main(String[] args) throws Exception {
        List<Employees> dc=ServiceFactory.getEmployeesServiceInstance().list();
        Iterator<Employees> idc = dc.iterator();
        while(idc.hasNext()){
            Employees ee = idc.next();
            System.out.println(ee.toString());
        }
    }
}
