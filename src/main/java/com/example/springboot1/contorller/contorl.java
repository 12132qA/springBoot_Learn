package com.example.springboot1.contorller;
import com.example.springboot1.Mapper.AirMapper;
import com.example.springboot1.Mapper.UserMapper;
import com.example.springboot1.Mapper.login1;
import com.example.springboot1.pojo.Login;
import com.example.springboot1.pojo.User;
import com.example.springboot1.pojo.air;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController  // 前后端分离的技术
public class contorl {
    @Autowired
    private AirMapper airMapper2;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private login1 login;
    @Autowired
    private air use2;
    @RequestMapping("/air/findAll")
    public List findAll(){
        List<User> users = userMapper.selectAllAirById();
        users.forEach(System.out::println);
        List<User> users2 = new ArrayList<>();
       users.forEach(user -> {  // 过滤
           if(user.getAir()!=null){
               users2.add(user);
           }
       });
        return users2;
    }
    @RequestMapping("/User/findAll")
    public List findAll1(){
        List<air> airs = airMapper2.selectAllUserById();
        List<air> airs2 = new ArrayList<>();
        airs.forEach(air -> {
            if(air.getUser()!=null){
                airs2.add(air);
            }
        });
        return  airs2;
    }
    @RequestMapping("/mysqlPost")
     // 解决跨域的过滤器
    public Object show() {
        System.out.println("mysqlpost 响应");
        return airMapper2.list();
    }
    @RequestMapping("/mysqlQuery")
    public Object query(String id) {
        System.out.println("query 响应");
        return airMapper2.query(id);
    }
    @RequestMapping(value = "/mysqlInsert")
    public int Insert( String id, String planeName,String ran) {
        System.out.println("query 响应 ------");
        air air = new air(id,planeName,ran);
        return airMapper2.insert(air);
    }

    @RequestMapping("/mysqlDelete")
    public int Delete( String id) {
        System.out.println("Delete 响应");
        return airMapper2.delete(id);
    }
    @RequestMapping("/mysqlUpdate")
    public int update(String id,String planeName,String ran,String idf){
        System.out.println("Update 响应");
        return airMapper2.update(id,planeName,ran,idf);
    }

    @CrossOrigin
    @RequestMapping("/mysqlLogin")
    public String Lgoin(Login le){
        System.out.println("Login 响应");
        System.out.println(le);
        System.out.println(le.getPassword() +"  "+le.getName());

       Login l= login.list(le.getName());
       if(l==null){
           System.out.println("登录错误 无此用户");
           return "NO1";
       }

       if(Objects.equals(l.getPassword(), le.getPassword())) {
           System.out.println("登录成功");
           return "YES";
       }else{
           System.out.println("登录失败  密码问题");
       }
       return "NO2";
    }
    @GetMapping(value="/")
    public String run() {
        System.out.println("hell 响应");
        return "你好。。。。。。。。。。。。。。";
    }
    @GetMapping(value = "mapvalue")
    public @ResponseBody
    Map<String ,Object> mapvalue(){
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("message", "Springboot Project");
        retMap.put("id","you");
        System.out.println("mapvalue 响应");

        return retMap;
    }
    @GetMapping(value = "y")  //
    public @ResponseBody Object say(String page){
        System.out.println("ResponseBody 响应");
        return "page: " + page;
    }
}

