package com.fh.action;

import com.fh.action.YH.ServletRequest;
import com.fh.model.Emp;
import com.fh.model.empQuery;
import com.fh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("emp")
@CrossOrigin
public class EmpAction {
    @Autowired
    private EmpService empService;


    @RequestMapping("queryEmpList")
    public ServletRequest queryEmpList(empQuery proQuery){
        return empService.queryEmpList(proQuery);
    }

    @RequestMapping("queryJobList")
    public ServletRequest queryJobList(){
        return empService.queryJobList();
    }
    @RequestMapping("queryLeaderList")
    public ServletRequest queryLeaderList(Integer deptID){
        return empService.queryLeaderList(deptID);
    }
    @RequestMapping("queryDeptList")
    public ServletRequest queryDeptList(){
        return empService.queryDeptList();
    }
    @RequestMapping("addEmp")
    public ServletRequest addEmp(Emp emp){
        return empService.addEmp(emp);
    }
}
