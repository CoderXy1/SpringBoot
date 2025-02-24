package com.xy.aurora.Service;


import com.xy.aurora.Model.VideoEntity;
import java.util.List;

public interface VideoService {

    List<VideoEntity> queryList(int pageNum, int pageSize, String searchKey);

    VideoEntity querySingle(String videoId);

    void insert(VideoEntity videoEntity);

    void update(VideoEntity videoEntity);

    void updatePlayCount(String videoId);

    void delete(String videoId);
}
