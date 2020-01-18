package com.fh.util;

import com.fh.action.ZJ.ExcelFild;
import com.fh.action.ZJ.ExcelHeard;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Excel_Util {

    public static void downExcel(List  list, HttpServletResponse response){
        //处理标题
        Object o = list.get(0);//得到要下载的对象
        Class aClass = o.getClass();//得到类的类对象
        //获取标题名   标题名在注解上
        ExcelHeard annotation = (ExcelHeard) aClass.getAnnotation(ExcelHeard.class);
        //获取标题名
        String title = annotation.title();
        XSSFWorkbook wk=new XSSFWorkbook();
        XSSFSheet sheet = wk.createSheet(title);
        XSSFRow row = sheet.createRow(0);
        //处理列头
        //得到类的所有属性
        Field[] declaredFields = aClass.getDeclaredFields();
        int cellNum=0;
        for (int i = 0; i <declaredFields.length ; i++) {
            //具体的每一个属性
            Field field = declaredFields[i];
            ExcelFild excelFild = field.getAnnotation(ExcelFild.class);
            if(excelFild!=null){
                String name = excelFild.name();
                XSSFCell cell = row.createCell(cellNum);
                cell.setCellValue(name);
                cellNum++;
            }
        }
        //处理数据
        for (int i = 0; i <list.size() ; i++) {
            // 获取具体的数据
            Object o1 = list.get(i);
            XSSFRow row1 = sheet.createRow(i + 1);
            int cell1=0;
            for (int j = 0; j < declaredFields.length; j++) {
                //具体的每一个属性
                Field field = declaredFields[j];
                boolean b = field.isAnnotationPresent(ExcelFild.class);
                if(b==true){
                    XSSFCell cell = row1.createCell(cell1);
                    //获取属性的值  在反射中  对类对象来说
                    field.setAccessible(true);
                    try {
                        Object o2 = field.get(o1);
                        if(o2!=null){
                            //判断属性的类型
                            Class<?> type = field.getType();
                            if(type== Date.class){
                                //格式化日期
                                SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
                                Date date= (Date) o2;
                                String format = sim.format(date);
                                cell.setCellValue(format);
                            }else {
                                cell.setCellValue(o2.toString());
                            }
                        }else {
                            cell.setCellValue("");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    cell1++;
                }
            }


        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment; filename=\""+ UUID.randomUUID().toString()+".xlsx\"");

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            wk.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
