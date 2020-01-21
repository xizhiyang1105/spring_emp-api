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
    public ServletRequest queryLeaderList() {
        List<Emp> list=empDao.queryLeaderList();
        return ServletRequest.success(list);
    }

    @Override
    public ServletRequest addEmp(Emp emp) {
        Integer a=1;
        Integer jobId = emp.getJobId();
        Emp emp1=empDao.queryName(emp);
        if(emp1==null){
            if(jobId==2||jobId==4||jobId==5){
                emp.setZt(1);
                empDao.insert(emp);
            }else{
                emp.setZt(2);
                empDao.insert(emp);
            }
        }else {
            return ServletRequest.success(a);
        }
        return ServletRequest.success();
    }

    @Override
    public void delEmpByList(List list) {
        empDao.delEmpByList(list);
    }

    @Override
    public void delEmpId(Integer id) {
        empDao.deleteById(id);
    }

    @Override
    public List<Emp> querylist(empQuery empQuery) {
        List<Emp>list=empDao.selectEmpList(empQuery);
        return list;
    }

    @Override
    public ServletRequest toUpEmpById(Integer id) {
        Emp emp = empDao.selectById(id);
        return ServletRequest.success(emp);
    }

    @Override
    public ServletRequest UpEmpById(Emp emp) {
        Integer a=1;
        Integer jobId = emp.getJobId();
        Emp emp1=empDao.queryName(emp);
        if(emp1==null){
            if(jobId==2||jobId==4||jobId==5){
                emp.setZt(1);
                empDao.updateById(emp);
            }else{
                emp.setZt(2);
                empDao.updateById(emp);
            }
        }else {
            return ServletRequest.success(a);
        }
        return ServletRequest.success();
    }
}
