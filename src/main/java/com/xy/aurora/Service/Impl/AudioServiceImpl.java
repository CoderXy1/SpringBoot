package com.xy.aurora.Service.Impl;

import com.xy.aurora.Mapper.AudioMapper;
import com.xy.aurora.Model.AudioEntity;
import com.xy.aurora.Service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioServiceImpl implements AudioService {

    @Autowired
    private AudioMapper audioMapper;

    @Override
    public List<AudioEntity> queryList(int pageNum, int pageSize, String searchKey) {
        int offset = (pageNum - 1) * pageSize;
        return audioMapper.queryList(offset,pageSize,searchKey);
    }

    @Override
    public AudioEntity querySingle(String audioId) {
        return audioMapper.querySingle(audioId);
    }

    @Override
    public void insert(AudioEntity audioEntity) {
        audioMapper.insert(audioEntity);
    }

    @Override
    public void update(AudioEntity audioEntity) {
        audioMapper.update(audioEntity);
    }

    @Override
    public void delete(String audioId) {
        audioMapper.delete(audioId);
    }
}
