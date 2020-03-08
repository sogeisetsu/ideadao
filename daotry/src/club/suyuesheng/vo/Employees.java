package club.suyuesheng.vo;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
//负责各层之间数据的传输和包装
public class Employees implements Serializable {
    public Employees(){}
    private Integer empno;
    private Date birthdate;
    private String firstname;
    private String lastname;
    private String gender;
    private Date hiredate;

    /**
     * 获得雇员编号
     * @return 返回雇员编号
     */
    public Integer getEmpno() {
        return empno;
    }

    /**
     * 设置雇员编号
     * @param empno 雇员编号
     */
    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    /**
     *获得雇员出生日期
     * @return 返回雇员出生日期Date
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * 设置雇员出生日期
     * @param birthdate Date类 雇员出生日期
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * 获得雇员的first_name
     * @return String类 雇员的名字
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * 设置雇员的名字
     * @param firstname String类 雇员的名字
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empno=" + empno +
                ", birthdate=" + birthdate +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", hiredate=" + hiredate +
                '}';
    }
}
