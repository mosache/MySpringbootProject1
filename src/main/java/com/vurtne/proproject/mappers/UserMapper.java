package com.vurtne.proproject.mappers;

import com.vurtne.proproject.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into t_User (name,avatar_url,token) values (#{name},#{avatar_url},#{token})")
    void insert(User user);

    @Select("select * from t_User where token=#{token}")
    User getUserByToken(String token);

    @Select("select * from t_User where id=#{id}")
    User getUserByID(int id);

}
