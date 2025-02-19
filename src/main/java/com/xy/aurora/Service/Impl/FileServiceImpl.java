package com.xy.aurora.Service.Impl;

import com.xy.aurora.Mapper.FileMapper;
import com.xy.aurora.Model.FileEntity;
import com.xy.aurora.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public List<FileEntity> queryList(int pageNum, int pageSize, String fileType, Date startDate, Date endDate,String fileName) {
        int offset = (pageNum - 1) * pageSize;
        List<FileEntity> files = fileMapper.queryList(offset,pageSize,fileType,startDate,endDate,fileName);
        return files;
    }

    @Override
    public void insert(FileEntity fileEntity) {
        fileMapper.insert(fileEntity);
    }

    @Override
    public List<Map<String,Object>> queryTypes() {
        return fileMapper.queryTypes();
    }
}
