package com.example.springboot1.contorller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/teacherLocationSign")
public class test {
    @PostMapping("/sign")
    @ResponseBody
    public String head(@RequestBody String s){

        return "ookkk!!!";
    }
}
