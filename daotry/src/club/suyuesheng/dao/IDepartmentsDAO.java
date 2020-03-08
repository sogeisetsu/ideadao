package club.suyuesheng.dao;

import club.suyuesheng.vo.Departments;

import java.util.List;
import java.util.Set;

/**
 * 定义departments数据层的开发标准
 * @author 苏月晟
 */
public interface IDepartmentsDAO {
    /**
     * 创建数据库中的数据，insert to操作
     * @param departments VO类
     * @return 创建成功就返回True，失败返回False
     * @throws Exception
     */
    public boolean doCreate(Departments departments) throws Exception;

    /**
     * 数据库数据的修改操作 UPDATE SET
     * @param departments VO类
     * @return 修改成功返回Ture，失败返回False
     * @throws Exception
     */
    public boolean doUpdate(Departments departments) throws Exception;

    /**
     * 数据库数据的删除操作  DELETE FROM
     * @param deptIds 部门的ID
     * @return 删除成功返回True
     * @throws Exception
     */
    public boolean doRemove(Set<String> deptIds) throws Exception;

    /**
     * 数据库数据的查询操作
     * @param deptId 部门ID
     * @return 返回符合部门ID的VO类 ，如果没有返回NULL
     * @throws Exception
     */
    public Departments findByDid(String deptId) throws Exception;

    /**
     * 查询整个表的数据
     * @return 返回整个表的数据 每行数据通过VO类包装 返回一个List集合
     * @throws Exception
     */
    public List<Departments> findAll() throws Exception;

    /**
     * 分页进行数据的模糊查询
     * @param column 模糊查询的列
     * @param keyWord 关键词
     * @param currentPage 当前所在页
     * @param lineSize 每页显示的行数
     * @return 返回符合条件的，每行数据通过VO类包装 返回一个List集合
     * @throws Exception
     */
    public List<Departments> findAllSplit(String column,String keyWord,Integer currentPage,Integer lineSize) throws Exception;

    /**
     * 模糊查询符合条件的数量的统计
     * @param column 模糊查询的列
     * @param keyWord 关键词
     * @return 返回统计的值 没有符合条件的是0
     * @throws Exception
     */
    public Integer getAllCount(String column,String keyWord) throws Exception;
}
