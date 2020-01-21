package com.fh.action;

import com.fh.action.YH.ServletRequest;
import com.fh.model.Emp;
import com.fh.model.empQuery;
import com.fh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;
import java.util.HashMap;
import java.util.List;
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
    public ServletRequest queryLeaderList(){
        return empService.queryLeaderList();
    }
    @RequestMapping("queryDeptList")
    public ServletRequest queryDeptList(){
        return empService.queryDeptList();
    }
    @RequestMapping("addEmp")
    public ServletRequest addEmp(Emp emp){
        return empService.addEmp(emp);
    }

    //批量删除
    @RequestMapping("delEmpByList")
    public ServletRequest delEmpByList(@RequestParam("ids[]") List list){
        empService.delEmpByList(list);
        return ServletRequest.success();
    }

    @RequestMapping("delEmpId")
    public ServletRequest delEmpId(Integer id){
        empService.delEmpId(id);
        return ServletRequest.success();
    }

    @RequestMapping("toUpEmpById")
    public ServletRequest toUpEmpById(Integer id){
        return empService.toUpEmpById(id);
    }

    @RequestMapping("UpEmpById")
    public ServletRequest UpEmpById(Emp emp){
        return empService.UpEmpById(emp);
    }
}
