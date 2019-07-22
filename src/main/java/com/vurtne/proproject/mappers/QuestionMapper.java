package com.vurtne.proproject.mappers;

import com.vurtne.proproject.dto.QuestionDTO;
import com.vurtne.proproject.model.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into t_Question (title,des,tag,creator_id) values (#{title},#{des},#{tag},#{creator_id})")
     void create(Question q);

    @Select("select * from t_Question order by add_time desc")
    @Results({
            @Result(property = "user",
                    column = "creator_id",
                    one = @One(select = "com.vurtne.proproject.mappers.UserMapper.getUserByID"))
                    })
    List<QuestionDTO> list();
}
