package com.xy.aurora.Mapper;

import com.xy.aurora.Model.DiaryEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DiaryMapper {

    @Select(" select d.*,f.FileName,f.FileUrl from diary d " +
            " left join file f on d.FileId = f.FileId " +
            " where d.Title like CONCAT('%', #{searchKey}, '%') or d.Content like CONCAT('%', #{searchKey}, '%') " +
            " order by d.CreateDate desc limit #{pageSize} offset #{pageNum} ")
    List<DiaryEntity> queryList(int pageNum, int pageSize, String searchKey);

    @Select(" select d.*,f.FileName,f.FileUrl from diary d " +
            " left join file f on d.FileId = f.FileId " +
            " where diaryId = #{diaryId} ")
    DiaryEntity querySingle(String diaryId);

    @Insert(" insert into diary(DiaryId, Title, Content,Weather,Temperature,LuckyValue,FileId,CreateDate) " +
            " VALUES(#{diaryId},#{title}, #{content}, #{weather},#{temperature},#{luckyValue},#{fileId}, #{createDate})")
    void insert(DiaryEntity diaryEntity);

    @Delete(" delete from diary where diaryId = #{diaryId} ")
    void delete(String diaryId);

    @Update(" update diary set Title = #{title},Content = #{content},Weather = #{weather},Temperature = #{temperature}," +
            " LuckyValue = #{luckyValue},UpdateDate = NOW() " +
            " where diaryId = #{diaryId}")
    void update(DiaryEntity diaryEntity);
}
