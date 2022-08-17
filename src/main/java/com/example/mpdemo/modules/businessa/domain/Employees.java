package com.example.mpdemo.modules.businessa.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Employees other = (Employees) that;
        return (this.getEmpNo() == null ? other.getEmpNo() == null : this.getEmpNo().equals(other.getEmpNo()))
            && (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate()))
            && (this.getFirstName() == null ? other.getFirstName() == null : this.getFirstName().equals(other.getFirstName()))
            && (this.getLastName() == null ? other.getLastName() == null : this.getLastName().equals(other.getLastName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getHireDate() == null ? other.getHireDate() == null : this.getHireDate().equals(other.getHireDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmpNo() == null) ? 0 : getEmpNo().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getFirstName() == null) ? 0 : getFirstName().hashCode());
        result = prime * result + ((getLastName() == null) ? 0 : getLastName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getHireDate() == null) ? 0 : getHireDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", empNo=").append(empNo);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", gender=").append(gender);
        sb.append(", hireDate=").append(hireDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}