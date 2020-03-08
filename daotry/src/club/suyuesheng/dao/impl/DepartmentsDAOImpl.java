package club.suyuesheng.dao.impl;

import club.suyuesheng.dao.IDepartmentsDAO;
import club.suyuesheng.vo.Departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DepartmentsDAOImpl implements IDepartmentsDAO {
    private PreparedStatement preparedStatement;
    private Connection connection;
    public DepartmentsDAOImpl(Connection connection){
        this.connection=connection;
    }
    @Override
    public boolean doCreate(Departments vo) throws Exception {
        String sql ="INSERT INTO departments(dept_no,dept_name) VALUES(?,?)";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, vo.getDeptno());
        this.preparedStatement.setString(2, vo.getDeptname());
        return this.preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Departments vo) throws Exception {
        String sql ="UPDATE dapartments SET dept_name = ? WHERE dept_no=?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, vo.getDeptname());
        this.preparedStatement.setString(2, vo.getDeptno());

        return this.preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean doRemove(Set<String> deptIds) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM departments WHERE dept_no IN(");
        Iterator<String> Ids = deptIds.iterator();
        while(Ids.hasNext()){
            sql.append(Ids.next()).append(",");
        }
        sql.delete(sql.length()-1,sql.length());
        this.preparedStatement=this.connection.prepareStatement(sql.toString());
        return this.preparedStatement.executeUpdate()==deptIds.size();
    }

    @Override
    public Departments findByDid(String deptId) throws Exception {
        String sql = "SELECT dept_no,dept_name FROM departments WHERE dept_no="+deptId;
        this.preparedStatement=this.connection.prepareStatement(sql);
        Departments departments = null;
        ResultSet resultSet =this.preparedStatement.executeQuery();
        if(resultSet.next()){
            departments = new Departments();
            departments.setDeptno(deptId);
            departments.setDeptname(resultSet.getString(2));
        }
        return departments;
    }

    @Override
    public List<Departments> findAll() throws Exception {
        List<Departments> all =null;
        String sql ="SELECT dept_no,dept_name FROM departments";
        this.preparedStatement=this.connection.prepareStatement(sql);
        ResultSet resultSet = this.preparedStatement.executeQuery();
        all = new ArrayList<Departments>();
        while(resultSet.next()){
            Departments departments = new Departments();
            departments.setDeptno(resultSet.getString(1));
            departments.setDeptname(resultSet.getString(2));
            all.add(departments);
        }
        return all;
    }

    @Override
    public List<Departments> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws Exception {
        List<Departments> all = null;
        String sql = "SELECT dept_no,dept_name FROM departments " +
                " WHERE " +column+" LIKE ? " +
                " LIMIT ?,?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, "%"+keyWord+"%");
        this.preparedStatement.setInt(2, (currentPage-1)*lineSize);
        this.preparedStatement.setInt(3, currentPage*lineSize);
        ResultSet resultSet =this.preparedStatement.executeQuery();
        all = new ArrayList<Departments>();
        Departments vo = null;
        while (resultSet.next()){
            vo=new Departments();
            vo.setDeptno(resultSet.getString(1));
            vo.setDeptname(resultSet.getString(2));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        Integer count =null;
        String sql ="SELECT COUNT(*) FROM employees " +
                " WHERE "+column+" LIKE ?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, "%"+keyWord+"%");
        ResultSet resultSet=this.preparedStatement.executeQuery();
        if(resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;
    }
}
