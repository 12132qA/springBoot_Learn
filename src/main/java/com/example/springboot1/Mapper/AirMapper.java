package com.example.springboot1.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot1.pojo.User;
import com.example.springboot1.pojo.air;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper // 运行时 实现类对象 （动态代理对象）
public interface AirMapper extends BaseMapper<air> {
   @Select("select * from airinfro where Id=#{id}")
   air selectById(String id);

   @Select("select * from airinfro")
   @Results({
           @Result(column = "id",property = "id"),
           @Result(column = "planeName",property = "planeName"),
           @Result(column = "ran",property = "ran"),
           @Result(column = "id",property = "user",javaType = User.class ,  // 指定映射关系 id => user
                   one=@One(select = "com.example.springboot1.Mapper.UserMapper.selectByAirId") //
           )
   })
   List<air> selectAllUserById();

 // 查询全部用户信息
    // 配置sql提示
    @Select("select * from airinfro")
    public List<air> list();
    @Delete("delete from airinfro where id=#{id}")
    public int delete(String id);
    @Select("select * from airinfro where id=#{id}")
    public air query(String id);
    @Insert("insert into airinfro values(#{id},#{planeName},#{ran})")
    public int insert(air air);
    @Update("update airinfro set id=#{id} ,planeName=#{planeName},ran=#{ran} where id=#{UPid}")
    public int update(String id,String planeName,String ran,String UPid);
}
