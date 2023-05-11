package com.example.mpdemo.modules.businessa.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 
 * @TableName employees
 */
@TableName(value ="employees")
public class Employees implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer empNo;

    /**
     * 
     */
    private Date birthDate;

    /**
     * 
     */
    private String firstName;

    /**
     * 
     */
    private String lastName;

    /**
     * 
     */
    private Object gender;

    /**
     * 
     */
    private Date hireDate;

    private String remind;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getEmpNo() {
        return empNo;
    }

    /**
     * 
     */
    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    /**
     * 
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     */
    public Object getGender() {
        return gender;
    }

    /**
     * 
     */
    public void setGender(Object gender) {
        this.gender = gender;
    }

    /**
     * 
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * 
     */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getRemind() {
        return remind;
    }

    public void setRemind(String remind) {
        this.remind = remind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return Objects.equals(empNo, employees.empNo) && Objects.equals(birthDate, employees.birthDate) && Objects.equals(firstName, employees.firstName) && Objects.equals(lastName, employees.lastName) && Objects.equals(gender, employees.gender) && Objects.equals(hireDate, employees.hireDate) && Objects.equals(remind, employees.remind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, birthDate, firstName, lastName, gender, hireDate, remind);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empNo=" + empNo +
                ", birthDate=" + birthDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", hireDate=" + hireDate +
                ", remind='" + remind + '\'' +
                '}';
    }
}