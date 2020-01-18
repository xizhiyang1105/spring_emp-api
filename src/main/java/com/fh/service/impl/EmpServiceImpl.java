package com.fh.service.impl;

import com.fh.action.YH.ServletRequest;
import com.fh.dao.EmpDao;
import com.fh.model.Dept;
import com.fh.model.Emp;
import com.fh.model.Job;
import com.fh.model.empQuery;
import com.fh.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpDao empDao;

    @Override
    public ServletRequest queryEmpList(empQuery proQuery) {
        Map map=new HashMap();
        Integer count=empDao.queryCount(proQuery);
        List drugList=empDao.queryList(proQuery);
        map.put("draw",proQuery.getDraw());
        map.put("recordsTotal",count);
        map.put("recordsFiltered",count);
        map.put("data",drugList);
        return ServletRequest.success(map);
    }

    @Override
    public ServletRequest queryJobList() {
        List<Job> list=empDao.queryJobList();
        return ServletRequest.success(list);
    }

    @Override
    public ServletRequest queryDeptList() {
        List<Dept> list=empDao.queryDeptList();
        return ServletRequest.success(list);
    }

    @Override
    public ServletRequest queryLeaderList(Integer deptID) {
        List<Emp> list=empDao.queryLeaderList(deptID);
        return ServletRequest.success(list);
    }

    @Override
    public ServletRequest addEmp(Emp emp) {
        empDao.insert(emp);
        return ServletRequest.success();
    }
}
