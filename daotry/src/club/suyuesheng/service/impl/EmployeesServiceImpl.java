package club.suyuesheng.service.impl;

import club.suyuesheng.dbc.DatabaseConnection;
import club.suyuesheng.factory.DAOFactory;
import club.suyuesheng.service.IEmployeesService;
import club.suyuesheng.vo.Employees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 苏月晟
 */
public class EmployeesServiceImpl implements IEmployeesService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Employees vo) throws Exception {
        try{
            if(DAOFactory.getIEmployeesDAOInstance(this.dbc.getConnection()).findById(vo.getEmpno())==null){
                return DAOFactory.getIEmployeesDAOInstance(this.dbc.getConnection()).doCreate(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return false;
    }

    @Override
    public boolean update(Employees vo) throws Exception {
        try{
            return DAOFactory.getIEmployeesDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return false;
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try{
            if(ids.size()==0){
                return false;
            }
            return DAOFactory.getIEmployeesDAOInstance(this.dbc.getConnection()).doRemove(ids);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return false;
    }

    @Override
    public Employees get(int id) throws Exception {
        try{
            return DAOFactory.getIEmployeesDAOInstance(this.dbc.getConnection()).findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return null;
    }

    @Override
    public List<Employees> list() throws Exception {
        try{
            return DAOFactory.getIEmployeesDAOInstance(this.dbc.getConnection()).findAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return null;
    }

    @Override
    public Map<String, Object> listSplit(String column, String keyWord, int currentPage, int lineSize) throws Exception {
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("allEmployees",DAOFactory.getIEmployeesDAOInstance(this.dbc.getConnection()).findAllSplit(column, keyWord, currentPage, lineSize));
            map.put("employeesCount", DAOFactory.getIEmployeesDAOInstance(this.dbc.getConnection()).getAllCount(column, keyWord));
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return null;
    }
}
