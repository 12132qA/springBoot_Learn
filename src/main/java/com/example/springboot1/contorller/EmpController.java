package com.example.springboot1.contorller;

import com.example.springboot1.pojo.Emp;
import com.example.springboot1.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
public class EmpController {
     @RequestMapping("/listEmp")
    public Result list(){
         // 加载并解析 emp.xml
         String file = Objects.requireNonNull(this.getClass().getClassLoader().getResource("emp.xml")).getFile();
         System.out.println(file);
         List<Emp> parse = XmlParserUtils.parse(file, Emp.class);
         //对数据进行转换处理
         parse.stream().forEach(emp -> {
             String gender = emp.getGender();
             if("1".equals(gender)){
                 emp.setGender("男");
             }else if("2".equals(gender)){
                   emp.setGender("女");
             }

             // 处理job -1 :讲师 2 班主任 3 就业指导

             String job = emp.getJob();
             if("1".equals(gender)){
                 emp.setJob("讲师");
             }else if("2".equals(gender)){
                 emp.setJob("班主任");
             }else if("3".equals(job)){
                 emp.setJob("就业指导");
             }
         });
         // 3 响应数据
         return Result.success(parse);
     }

}
