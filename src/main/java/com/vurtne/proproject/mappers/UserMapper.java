package com.vurtne.proproject.mappers;

import com.vurtne.proproject.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into t_User (name,avatar_url,token,github_id) values (#{name},#{avatar_url},#{token},#{github_id})")
    void insert(User user);

    @Select("select * from t_User where token=#{token}")
    User getUserByToken(String token);

    @Select("select * from t_User where github_id=#{github_id}")
    User getUserByGitHubID(int github_id);

    @Select("select * from t_User where id=#{id}")
    User getUserByID(int id);

    @Update("update t_User set token=#{newToken} where id=#{id}")
    void updateUserToken(@Param("id") Long id, @Param("newToken") String newToken);
}
