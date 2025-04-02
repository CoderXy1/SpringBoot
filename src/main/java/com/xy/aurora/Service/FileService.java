package com.xy.aurora.Service;

import com.xy.aurora.Model.FileEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FileService {
    List<FileEntity> queryList(int pageNum, int pageSize, String fileType, Date startDate, Date endDate,String fileName);

    Integer queryTotal();

    void insert(FileEntity fileEntity);

    List<Map<String,Object>> queryTypes();
}
