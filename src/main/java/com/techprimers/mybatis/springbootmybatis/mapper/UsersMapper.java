package com.techprimers.mybatis.springbootmybatis.mapper;

import com.techprimers.mybatis.springbootmybatis.model.Users;
import jakarta.websocket.server.PathParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users")
    List<Users> findAll();

    @Select("select * from users where id=#{name}")
    List<Users> findOne(@PathParam("name") final int name);

    @Insert("insert into users(name,salary) values(#{name},#{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Users users);

    @Update("Update users set salary=#{salary} where name=#{name}")
    void update(Users users);


    @Delete("Delete from users where name=#{name}")
    void delete(Users users);
}
