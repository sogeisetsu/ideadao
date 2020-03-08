package club.suyuesheng.dao;

import club.suyuesheng.vo.Employees;

import java.util.List;
import java.util.Set;

/**
 * 定义数据表employees数据层开发标准
 * @author 苏月晟
 */
public interface IEmployeesDAO {

    /**
     * 数据的增加操作 执行insert语句
     * @param employees 参数是VO类
     * @return 如果数据增加成功就是True 如果数据增加失败就使False
     * @throws Exception 数据库没有连接或者SQL语句出错
     */
    public boolean doCreate(Employees employees) throws Exception;

    /**
     * 数据的更新操作，执行的是Update语句
     * @param employees vo类 要修改的数据信息
     * @return 数据修改成功返回Ture，失败返回False
     * @throws Exception
     */
    public boolean doUpdate(Employees employees) throws Exception;

    /**
     * 数据的删除操作 delete from
     * @param ids 数据的id集合成Set类
     * @return 删除成功返回true 失败返回false
     * @throws Exception
     */
    public boolean doRemove(Set<Integer> ids) throws Exception;

    /**
     * 查询操作，根据id编号查询
     * @param id id编号
     * @return 有符合编号的数据就返回VO类，没有就返回NULL
     * @throws Exception
     */
    public Employees findById(Integer id) throws Exception;

    /**
     * 查询表全部数据
     * @return List集合的形式返回 如果是空的就表的长度为0
     * @throws Exception
     */
    public List<Employees> findAll() throws Exception;

    /**
     * 分页显示模糊查询的结果
     * @param column 模糊查询的数据列
     * @param keyWord 关键字
     * @param currentPage 当前所在页
     * @param lineSize 每页显示的数据行数
     * @return List集合的形式返回 如果是空的就表的长度为0
     * @throws Exception
     */
    public List<Employees> findAllSplit(String column,String keyWord,Integer currentPage,Integer lineSize) throws Exception;

    /**
     * 模糊查询数据的统计
     * @param column 模糊查询的列
     * @param keyWord 关键字
     * @return 返回查询到数据的长度
     * @throws Exception
     */
    public Integer getAllCount(String column,String keyWord) throws Exception;
}
