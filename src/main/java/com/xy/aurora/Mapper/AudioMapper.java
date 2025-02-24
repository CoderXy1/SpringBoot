package com.xy.aurora.Mapper;

import com.xy.aurora.Model.AudioEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AudioMapper {

    @Select(" select a.*,f.FileName,f.FileUrl from audio a " +
            " left join file f on a.FileId = f.FileId " +
            " where a.AudioName like CONCAT('%', #{searchKey}, '%') or a.Singer like CONCAT('%', #{searchKey}, '%') " +
            " order by a.CreateDate desc limit #{pageSize} offset #{pageNum} ")
    List<AudioEntity> queryList(int pageNum, int pageSize, String searchKey);

    @Select(" select a.*,f.FileName,f.FileUrl from audio a " +
            " left join file f on a.FileId = f.FileId " +
            " where audioId = #{audioId} ")
    AudioEntity querySingle(String audioId);

    @Insert(" insert into audio(AudioId, AudioName, Singer,IsLove,FileId,CreateDate) " +
            " VALUES(#{audioId},#{audioName}, #{singer}, #{isLove},#{fileId}, #{createDate})")
    void insert(AudioEntity audioEntity);

    @Delete(" delete from audio where AudioId = #{audioId} ")
    void delete(String audioId);

    @Update(" update audio set AudioName = #{audioName},Singer = #{singer},IsLove = #{isLove},UpdateDate = NOW() " +
            " where AudioId = #{audioId}")
    void update(AudioEntity audioEntity);
}
