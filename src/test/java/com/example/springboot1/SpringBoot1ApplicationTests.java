package com.example.springboot1;

import com.example.springboot1.Mapper.AirMapper;
import com.example.springboot1.pojo.air;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
class SpringBoot1ApplicationTests {
    @Autowired
    private AirMapper airMapper;
    @Autowired
    private air use;
//    @Value("#{'${teacher.location.sign.time}'.split(',')}")
    @Value("#{'${teacher.location.sign.time.sport}'.split(',')}")
    private List<String> list;
    @Test
    void contextLoads() {
        for (String s : list) {
            System.out.println(s);
        }

        List<air> list = airMapper.list();
        list.forEach(System.out::println);
        airMapper.delete("19");
//        new AnnotationConfigApplicationContext(springConfig.class)
//        userMapper.insert();
//        User query = userMapper.query(23);
//        System.out.println(query);

        airMapper.update("air1988","56","mid","air1988");
    }

}
