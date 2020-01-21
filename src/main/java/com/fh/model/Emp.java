package com.fh.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fh.action.ZJ.ExcelFild;
import com.fh.action.ZJ.ExcelHeard;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("t_emp")
@ExcelHeard(title = "员工信息")
public class Emp {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @ExcelFild(name = "员工名称")
    private String name;
    private Integer jobId;
    @ExcelFild(name = "员工工资")
    private double salary;
    @ExcelFild(name = "入职时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTime;
    private Integer leaderId;
    private Integer deptId;
    private Integer zt;

    @TableField(exist = false)
    private String leaderName;
    @TableField(exist = false)
    private String jobName;
    @TableField(exist = false)
    private String deptName;

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
