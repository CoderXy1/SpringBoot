package com.xy.aurora.Service.Impl;

import com.xy.aurora.Mapper.VideoMapper;
import com.xy.aurora.Model.VideoEntity;
import com.xy.aurora.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<VideoEntity> queryList(int pageNum, int pageSize, String searchKey) {
        int offset = (pageNum - 1) * pageSize;
        return videoMapper.queryList(offset,pageSize,searchKey);
    }

    @Override
    public VideoEntity querySingle(String videoId) {
        return videoMapper.querySingle(videoId);
    }

    @Override
    public void insert(VideoEntity videoEntity) {
        videoMapper.insert(videoEntity);
    }

    @Override
    public void update(VideoEntity videoEntity) {
        videoMapper.update(videoEntity);
    }

    @Override
    public void updatePlayCount(String videoId) {
        videoMapper.updatePlayCount(videoId);
    }

    @Override
    public void delete(String videoId) {
        videoMapper.delete(videoId);
    }
}
