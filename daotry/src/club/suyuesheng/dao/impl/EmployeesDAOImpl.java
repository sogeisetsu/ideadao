package club.suyuesheng.dao.impl;

import club.suyuesheng.dao.IEmployeesDAO;
import club.suyuesheng.vo.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EmployeesDAOImpl implements IEmployeesDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;

    /**
     * 数据库的连接交给业务层，数据层负责原子性功能的实现，
     * @param connection
     */
    public EmployeesDAOImpl(Connection connection){
        this.connection=connection;
    }
    @Override
    public boolean doCreate(Employees vo) throws Exception {
        String sql ="INSERT INTO employees(emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (?,?,?,?,?,?)";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1,vo.getEmpno() );
        this.preparedStatement.setDate(2, new java.sql.Date(vo.getBirthdate().getTime()));
        this.preparedStatement.setString(3, vo.getFirstname());
        this.preparedStatement.setString(4, vo.getLastname());
        this.preparedStatement.setString(5, vo.getGender());
        this.preparedStatement.setDate(6, new java.sql.Date(vo.getHiredate().getTime()));
        return this.preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Employees vo) throws Exception {
        String sql="UPDATE employees SET birth_date=?,first_name=?,last_name=?,gender=?,hire_date=? WHERE emp_no=?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setDate(1, new java.sql.Date(vo.getBirthdate().getTime()));
        this.preparedStatement.setString(2, vo.getFirstname());
        this.preparedStatement.setString(3, vo.getLastname());
        this.preparedStatement.setString(4, vo.getGender());
        this.preparedStatement.setDate(5, new java.sql.Date(vo.getHiredate().getTime()));
        this.preparedStatement.setInt(6, vo.getEmpno());
        return this.preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean doRemove(Set<Integer> ids) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM employees WHERE emp_no IN(");
        Iterator<Integer> iter = ids.iterator();
        while(iter.hasNext()){
            sql.append(iter.next()).append(",");
        }
        sql.delete(sql.length()-1, sql.length());//删除多出来的逗号
        sql.append(")");
        this.preparedStatement=this.connection.prepareStatement(sql.toString());
        return this.preparedStatement.executeUpdate()==ids.size();
    }

    @Override
    public Employees findById(Integer id) throws Exception {
        Employees vo = null;
        String sql ="SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees WHERE emp_no=?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, id);
        ResultSet rs = this.preparedStatement.executeQuery();
        if(rs.next()){
            vo=new Employees();
            vo.setEmpno(rs.getInt(1));
            vo.setBirthdate(rs.getDate(2));
            vo.setFirstname(rs.getString(3));
            vo.setLastname(rs.getString(4));
            vo.setGender(rs.getString(5));
            vo.setHiredate(rs.getDate(6));
        }
        return vo;
    }

    @Override
    public List<Employees> findAll() throws Exception {
        List<Employees> all =null;
        String sql ="SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees";
        this.preparedStatement=this.connection.prepareStatement(sql);
        ResultSet rs = this.preparedStatement.executeQuery();
        all = new ArrayList<Employees>();
        Employees vo =null;
        while(rs.next()){
            vo=new Employees();
            vo.setEmpno(rs.getInt(1));
            vo.setBirthdate(rs.getDate(2));
            vo.setFirstname(rs.getString(3));
            vo.setLastname(rs.getString(4));
            vo.setGender(rs.getString(5));
            vo.setHiredate(rs.getDate(6));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Employees> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws Exception {
        List<Employees> all= null;
        String sql="SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees " +
                " WHERE " +column+"  LIKE ? " +
                " LIMIT ?,?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, "%"+keyWord+"%");
        this.preparedStatement.setInt(2, (currentPage-1)*lineSize);
        this.preparedStatement.setInt(3, lineSize);
        ResultSet rs = this.preparedStatement.executeQuery();
        all=new ArrayList<Employees>();
        while(rs.next()){
            Employees vo = new Employees();
            vo.setEmpno(rs.getInt(1));
            vo.setBirthdate(rs.getDate(2));
            vo.setFirstname(rs.getString(3));
            vo.setLastname(rs.getString(4));
            vo.setGender(rs.getString(5));
            vo.setHiredate(rs.getDate(6));
            all.add(vo);
        }
        return all;
    }
    /**
     * 模糊查询数据的统计
     * @param column 模糊查询的列
     * @param keyWord 关键字
     * @return 返回查询到数据的长度
     * @throws Exception
     */
    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        String sql = "SELECT COUNT(*) FROM employees " +
                " WHERE "+column+" LIKE ?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, "%"+keyWord+"%");
        ResultSet rs = this.preparedStatement.executeQuery();
        Integer count = null;
        if(rs.next()){
            count = rs.getInt(1);
        }
        return count;
    }
}
