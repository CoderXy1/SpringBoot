package com.xy.aurora.Service;


import com.xy.aurora.Model.DiaryEntity;

import java.util.List;

public interface DiaryService {

    List<DiaryEntity> queryList(int pageNum, int pageSize, String searchKey);

    DiaryEntity querySingle(String diaryId);

    void insert(DiaryEntity diaryEntity);

    void update(DiaryEntity diaryEntity);

    void delete(String diaryId);
}
