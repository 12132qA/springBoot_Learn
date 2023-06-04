package com.example.springboot1.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private String Cname;
    private String Connection;
    private String Cid;
    private Integer payment;
    private String airLd;
    @TableField(exist = false)
    private air air;
    public User(String cname, String connection, String cid, Integer payment, String airLd) {
        Cname = cname;
        Connection = connection;
        Cid = cid;
        this.payment = payment;
        this.airLd = airLd;
    }

}
