package com.xy.aurora.Mapper;

import com.xy.aurora.Model.VideoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Select(" select v.*,f.FileName,f.FileUrl from video v " +
            " left join file f on v.FileId = f.FileId " +
            " where v.Title like CONCAT('%', #{searchKey}, '%')" +
            " order by v.CreateDate desc limit #{pageSize} offset #{pageNum} ")
    List<VideoEntity> queryList(int pageNum, int pageSize, String searchKey);

    @Select(" select v.*,f.FileName,f.FileUrl from video v " +
            " left join file f on v.FileId = f.FileId " +
            " where VideoId = #{videoId} ")
    VideoEntity querySingle(String videoId);

    @Insert(" insert into video(VideoId, Title, FileId,CreateDate) " +
            " VALUES(#{videoId},#{title},#{fileId},#{createDate})")
    void insert(VideoEntity videoEntity);

    @Delete(" delete from video where VideoId = #{videoId} ")
    void delete(String videoId);

    @Update(" update video set Title = #{title},UpdateDate = NOW() where VideoId = #{videoId}")
    void update(VideoEntity videoEntity);

    @Update(" update video set PlayCount = PlayCount + 1,UpdateDate = NOW() where VideoId = #{videoId}")
    void updatePlayCount(String videoId);
}
