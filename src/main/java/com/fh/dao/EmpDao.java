package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.Dept;
import com.fh.model.Emp;
import com.fh.model.Job;
import com.fh.model.empQuery;

import java.util.List;

public interface EmpDao extends BaseMapper<Emp> {
    Integer queryCount(empQuery proQuery);

    List queryList(empQuery proQuery);

    List<Job> queryJobList();

    List<Dept> queryDeptList();

    List<Emp> queryLeaderList(Integer deptID);
}
