package com.vurtne.proproject.mappers;

import com.vurtne.proproject.dto.CommitDTO;
import com.vurtne.proproject.dto.CommitListDTO;
import com.vurtne.proproject.model.Commit;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface CommitMapper {

    @Insert("insert into t_Commit (parent_id,content,parent_type,creator_id) values (#{parent_id},#{content},#{parent_type},#{creator_id})")
    void insert(Commit commit);

    @Select("select * from t_Commit where id=#{id}")
    Commit getById(Long id);

    @Select("select * from t_Commit where parent_type=#{parent_type} and parent_id=#{parent_id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property ="parent_id",column = "parent_id"),
            @Result(property = "add_time",column = "add_time"),
            @Result(property = "modify_time",column = "modify_time"),
            @Result(property = "content",column = "content"),
            @Result(property = "parent_type",column = "parent_type"),
            @Result(property = "commit_count",column = "id",one = @One(select = "com.vurtne.proproject.mappers.CommitMapper.getSubCommitCountById")),
            @Result(property = "user",column = "creator_id",
                    one = @One(select = "com.vurtne.proproject.mappers.UserMapper.getUserByID")
            )
        }
    )
    ArrayList<CommitListDTO> list(CommitDTO commitDTO);

    @Select("select count(*) from t_Commit where parent_type=2 and parent_id=#{id}")
    Integer getSubCommitCountById(Long id);


}
