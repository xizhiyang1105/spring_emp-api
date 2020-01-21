package com.fh.action;

import com.fh.model.Emp;
import com.fh.model.empQuery;
import com.fh.service.EmpService;
import com.fh.util.Excel_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("excel")
@CrossOrigin
public class ExcelAction {
    @Autowired
    private EmpService empService;

    @RequestMapping("downExcel")
    public void downExcel(HttpServletResponse response, empQuery empQuery){
        List<Emp> list= empService.querylist(empQuery);
        Excel_Util.downExcel(list,response);
    }
}
