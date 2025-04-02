package com.xy.aurora.Mapper;

import com.xy.aurora.Model.NoteEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select(" select * from note " +
            " where NoteTitle like CONCAT('%', #{searchKey}, '%') or Content like CONCAT('%', #{searchKey}, '%') " +
            " order by CreateDate desc limit #{pageSize} offset #{pageNum} ")
    List<NoteEntity> queryList(int pageNum,int pageSize,String searchKey);

    @Select("select count(*) as icount from note ")
    Integer queryTotal();

    @Select(" select * from note where NoteId = #{noteId}")
    NoteEntity querySingle(String noteId);

    @Insert("insert into note(NoteId, NoteTitle, Content, NoteColor,CreateDate) " +
            "VALUES(#{noteId}, #{noteTitle}, #{content}, #{noteColor}, #{createDate})")
    void insert(NoteEntity noteEntity);

    @Delete("delete from note where NoteId = #{noteId} ")
    void delete(String noteId);

    @Update("update note set NoteTitle = #{noteTitle},Content = #{content},NoteColor = #{noteColor},UpdateDate = NOW() " +
            "where NoteId = #{noteId}")
    void update(NoteEntity noteEntity);
}
