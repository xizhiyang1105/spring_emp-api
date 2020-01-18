package com.fh.service;

import com.fh.action.YH.ServletRequest;
import com.fh.model.Emp;
import com.fh.model.empQuery;

public interface EmpService {
    ServletRequest queryEmpList(empQuery proQuery);

    ServletRequest queryJobList();

    ServletRequest queryDeptList();

    ServletRequest queryLeaderList(Integer deptID);

    ServletRequest addEmp(Emp emp);
}
