package com.example.springboot1.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data // 前四个功能的集成
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private String name;
    private Integer password;
    private Integer id;

}
