package com.xy.aurora.Mapper;

import com.xy.aurora.Model.GalleryEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GalleryMapper {

    @Select(" select g.*,f.FileName,f.FileUrl from gallery g " +
            " left join file f on g.FileId = f.FileId " +
            " where g.GalleryName like CONCAT('%', #{searchKey}, '%') or g.GalleryDescribe like CONCAT('%', #{searchKey}, '%') " +
            " order by g.CreateDate desc limit #{pageSize} offset #{pageNum} ")
    List<GalleryEntity> queryList(int pageNum,int pageSize,String searchKey);

    @Select(" select g.*,f.FileName,f.FileUrl from gallery g " +
            " left join file f on g.FileId = f.FileId " +
            " where galleryId = #{galleryId} ")
    GalleryEntity querySingle(String galleryId);

    @Insert("insert into gallery(GalleryId, GalleryName, GalleryDescribe,FileId,CreateDate) " +
            "VALUES(#{galleryId}, #{galleryName}, #{galleryDescribe}, #{fileId}, #{createDate})")
    void insert(GalleryEntity galleryEntity);

    @Delete("delete from gallery where galleryId = #{galleryId} ")
    void delete(String galleryId);

    @Update("update gallery set GalleryName = #{galleryName}, GalleryDescribe =  #{galleryDescribe},UpdateDate = NOW() " +
            "where galleryId = #{galleryId}")
    void update(GalleryEntity galleryEntity);
}
