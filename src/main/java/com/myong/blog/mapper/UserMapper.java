package com.myong.blog.mapper;

import com.myong.blog.modul.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (NAME,TOKEN,ACCOUNT_ID,CURRENT_ADDRESS) values (#{name},#{token},#{accoutId},#{currentAddress})")
    void insert(User user);
    @Select("select * from user where TOKEN = #{token}")
    User findByToken(@Param("token") String token);
    @Select("select * from user order by id desc limit 1")
    User findUser();
}
