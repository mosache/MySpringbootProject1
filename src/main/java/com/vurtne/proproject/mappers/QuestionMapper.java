package com.vurtne.proproject.mappers;

import com.vurtne.proproject.dto.QuestionDTO;
import com.vurtne.proproject.model.Question;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into t_Question (title,des,tag,creator_id) values (#{title},#{des},#{tag},#{creator_id})")
     void create(Question q);

    @Select("select * from t_Question order by add_time desc limit #{offSet},#{size}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "des",column = "des"),
            @Result(property = "tag",column = "tag"),
            @Result(property = "add_time",column = "add_time"),
            @Result(property = "modify_time",column = "modify_time"),
            @Result(property = "creator_id",column = "creator_id"),
            @Result(property = "view_count",column = "view_count"),
            @Result(property = "commit_count",column = "commit_count"),
            @Result(property = "like_count",column = "like_count"),
            @Result(property = "user",
                    column = "creator_id",
                    one = @One(select = "com.vurtne.proproject.mappers.UserMapper.getUserByID"))
                    })
    ArrayList<QuestionDTO> list(@Param("offSet")int offSet, @Param("size") int size);

    @Select("select * from t_Question where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "des",column = "des"),
            @Result(property = "tag",column = "tag"),
            @Result(property = "add_time",column = "add_time"),
            @Result(property = "modify_time",column = "modify_time"),
            @Result(property = "creator_id",column = "creator_id"),
            @Result(property = "view_count",column = "view_count"),
            @Result(property = "commit_count",column = "commit_count"),
            @Result(property = "like_count",column = "like_count"),
            @Result(property = "user",
                    column = "creator_id",
                    one = @One(select = "com.vurtne.proproject.mappers.UserMapper.getUserByID"))
    })
   QuestionDTO getQuestionByID(@Param("id")Long id);

    @Select("select * from t_Question where creator_id=#{userID} order by add_time desc limit #{offSet},#{size}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "des",column = "des"),
            @Result(property = "tag",column = "tag"),
            @Result(property = "add_time",column = "add_time"),
            @Result(property = "modify_time",column = "modify_time"),
            @Result(property = "creator_id",column = "creator_id"),
            @Result(property = "view_count",column = "view_count"),
            @Result(property = "commit_count",column = "commit_count"),
            @Result(property = "like_count",column = "like_count"),
            @Result(property = "user",
                    column = "creator_id",
                    one = @One(select = "com.vurtne.proproject.mappers.UserMapper.getUserByID"))
    })
    ArrayList<QuestionDTO> listByUserID(@Param("userID")Long userID,@Param("offSet")int offSet, @Param("size") int size);



    @Select("select count(1) from t_Question")
    Integer getTotalCount();

    @Select("select count(1) from t_Question where creator_id=#{userID} ")
    Integer getTotalCountByUserID(@Param("userID") Long userID);

    @Update("update t_Question set title=#{title},des=#{des},tag=#{tag} where id=#{id}")
    void updateQuestion(Question q);

    @Update("update t_Question set view_count = view_count + #{view_count} where id=#{id}")
    void addViewCount(Question q);

    @Update("update t_Question set commit_count = commit_count + #{commit_count} where id=#{id}")
    void addCommitCount(Question q);


}
