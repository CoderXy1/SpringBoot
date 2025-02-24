package com.xy.aurora.Service;



import com.xy.aurora.Model.AudioEntity;

import java.util.List;

public interface AudioService {

    List<AudioEntity> queryList(int pageNum, int pageSize, String searchKey);

    AudioEntity querySingle(String audioId);

    void insert(AudioEntity audioEntity);

    void update(AudioEntity audioEntity);

    void delete(String audioId);
}
