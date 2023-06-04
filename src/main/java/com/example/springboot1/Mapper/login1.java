package com.example.springboot1.Mapper;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot1.pojo.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper // 运行时 实现类对象 （动态代理对象）
                         //     myBatisPlus 功能
public interface login1 extends BaseMapper<Login> {  // 自动实现增删改查
    @Select("select * from login where name= #{name}")
    public Login list(String name);
}