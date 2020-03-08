package club.suyuesheng.vo;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Departments implements Serializable {
    public Departments(){}
    private String deptno;
    private String deptname;

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
}
