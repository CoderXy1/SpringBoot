package com.xy.aurora.Service.Impl;

import com.xy.aurora.Mapper.DiaryMapper;
import com.xy.aurora.Model.DiaryEntity;
import com.xy.aurora.Service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public List<DiaryEntity> queryList(int pageNum, int pageSize, String searchKey) {
        int offset = (pageNum - 1) * pageSize;
        return diaryMapper.queryList(offset,pageSize,searchKey);
    }

    @Override
    public DiaryEntity querySingle(String diaryId) {
        return diaryMapper.querySingle(diaryId);
    }

    @Override
    public void insert(DiaryEntity diaryEntity) {
        diaryMapper.insert(diaryEntity);
    }

    @Override
    public void update(DiaryEntity diaryEntity) {
        diaryMapper.update(diaryEntity);
    }

    @Override
    public void delete(String diaryId) {
        diaryMapper.delete(diaryId);
    }
}
