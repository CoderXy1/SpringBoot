package com.xy.aurora.Mapper;

import com.xy.aurora.Mapper.SqlProvider.FileSqlProvider;
import com.xy.aurora.Model.FileEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface FileMapper {

    @SelectProvider(type = FileSqlProvider.class,method = "queryList")
    List<FileEntity> queryList(int pageNum, int pageSize, String fileType, Date startDate, Date endDate,String fileName);

    @Insert("insert into file(FileId, FileName, FileType, FileUrl, CreateDate, UpdateDate) " +
            "VALUES(#{fileId}, #{fileName}, #{fileType}, #{fileUrl}, #{createDate}, #{updateDate})")
    void insert(FileEntity fileEntity);

    @Select("select '全部类别' as text,'' as value union all " +
            "(select FileType as text,FileType as value from file group by FileType order by count(FileType) desc)")
    List<Map<String,Object>> queryTypes();
}
