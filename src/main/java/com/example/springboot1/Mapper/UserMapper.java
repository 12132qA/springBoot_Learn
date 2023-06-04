package com.example.springboot1.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot1.pojo.User;
import com.example.springboot1.pojo.air;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 配置sql提示
    @Select("select * from clentinf")
    public List<air> list();

    @Select("select * from clentinf where airId=#{airId}")
    public User selectByAirId(String airId);  // 选择

    @Select("select * from clentinf")
    @Results({
            @Result(column = "airId",property = "airLd"), //    查询的sql字段对应类的属性值 从而完成映射连接
            @Result(column = "Cid",property = "Cid"),
            @Result(column = "payment",property = "payment"),
            @Result(column = "Cname",property = "Cname"),
            @Result(column = "Connection",property = "Connection"),
            @Result(column = "airId",property = "air",javaType = air.class ,  // 指定映射关系
                    many=@Many(select = "com.example.springboot1.Mapper.AirMapper.selectById")
            )})
    List<User> selectAllAirById();
    @Delete("delete from clentinf where Cid=#{id}")
    public int delete(String id);
    @Select("select * from clentinf where Cid=#{id}")
    public air query(String id);
    @Insert("insert into clentinf values(#{Cname},#{Connenction},#{Cid},#{payment},#{airId})")
    public int insert(User user);
    @Update("update clentinf set Cname=#{Cname} ,payment=#{payment},airId=#{id},Connection=#{Connection},airId=#{airId} where Cid=#{UPid}")
    public int update(String Cname,Integer payment,String Connection,String Cid,String airId ,String UPid);
}
