package club.suyuesheng.vo;

import java.util.Date;

@SuppressWarnings("serial")
public class Salaries {
    public Salaries(){}
    private Integer empno;
    private Integer salary;
    private Date formdate;
    private Date todate;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getFormdate() {
        return formdate;
    }

    public void setFormdate(Date formdate) {
        this.formdate = formdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }
}
