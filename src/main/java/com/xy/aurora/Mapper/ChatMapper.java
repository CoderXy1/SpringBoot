package com.xy.aurora.Mapper;

import com.xy.aurora.Model.ChatEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatMapper {

    @Select(" select * from chat " +
            " order by ChatTime limit #{pageSize} offset #{pageNum} ")
    List<ChatEntity> queryList(int pageNum, int pageSize);

    @Select(" select * from chat where ChatId = #{chatId}")
    ChatEntity querySingle(String chatId);

    @Insert("insert into chat(ChatId, ChatContent, ChatTime, UserType) " +
            "VALUES(#{chatId}, #{chatContent}, #{chatTime}, #{userType})")
    void insert(ChatEntity chatEntity);

    @Delete("delete from chat where ChatId = #{chatId} ")
    void delete(String chatId);

}
