package club.suyuesheng.service;

import club.suyuesheng.vo.Employees;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 业务层的接口
 * @author 苏月晟
 */
public interface IEmployeesService {
    /**
     * 增加一个雇员，先查看是否有符合的ID，然后再添加
     * @param vo 一条雇员的全部信息
     * @return 如果有一样的ID或者增加失败就返回false，否则返回Ture
     * @throws Exception
     */
    public boolean insert(Employees vo) throws Exception;

    /**
     * 修改一个雇员的信息
     * @param vo 要修改的雇员的全部信息
     * @return 修改成功返回true
     * @throws Exception
     */
    public boolean update(Employees vo) throws Exception;

    /**
     * 删除
     * @param ids 编号集合
     * @return 删除成功返回True
     * @throws Exception
     */
    public boolean delete(Set<Integer> ids) throws Exception;

    /**
     * 查询雇员的信息，根据ID返回一条雇员的信息
     * @param id
     * @return 返回一个VO类
     * @throws Exception
     */
    public Employees get(int id) throws Exception;

    /**
     * 返回所有雇员的信息
     * @return 返回一个VO类
     * @throws Exception
     */
    public List<Employees> list() throws Exception;

    /**
     * 模糊查询，分页显示，并返回
     * @param column 模糊查询的列
     * @param keyWord 关键词
     * @param currentPage 页码
     * @param lineSize 每页的长度
     * @return
     * <li>key=allEmployees ,value=IEmployeesDAO.getAllSplit()</li>
     * <li>key=employeesCount, value=IemployeesDAO.getAllCount<li/>
     * @throws Exception
     */
    public Map<String,Object> listSplit(String column,String keyWord,int currentPage,int lineSize) throws Exception;

}
