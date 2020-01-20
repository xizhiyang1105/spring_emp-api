package com.fh.service;

import com.fh.action.YH.ServletRequest;
import com.fh.model.Emp;
import com.fh.model.empQuery;

import java.util.List;

public interface EmpService {
    ServletRequest queryEmpList(empQuery proQuery);

    ServletRequest queryJobList();

    ServletRequest queryDeptList();

    ServletRequest queryLeaderList(Integer deptID);

    ServletRequest addEmp(Emp emp);

    void delEmpByList(List list);

    void delEmpId(Integer id);
}
