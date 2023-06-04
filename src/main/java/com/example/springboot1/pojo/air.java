package com.example.springboot1.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Component
@Data // 前四个功能的集成
@NoArgsConstructor
//@AllArgsConstructor
public class air {
//    @TableId(type= IdType.AUTO) // IdType自增
    private String id;
    private String planeName;
    private String ran;
    @TableField(exist = false)
    private User user;
    public air(String id,String planeName,String ran){
        this.id = id;
        this.planeName = planeName;
        this.ran = ran;
    }

//@TableField(exist = false) // 告诉框架该字段不存在 需手动映射
//    private List<Login> loginList;
}
