package com.xy.aurora.Service.Impl;

import com.xy.aurora.Mapper.GalleryMapper;
import com.xy.aurora.Model.GalleryEntity;
import com.xy.aurora.Service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryMapper galleryMapper;

    @Override
    public List<GalleryEntity> queryList(int pageNum, int pageSize,String searchKey) {
        int offset = (pageNum - 1) * pageSize;
        List<GalleryEntity> galleryList = galleryMapper.queryList(offset,pageSize,searchKey);
        return galleryList;
    }

    @Override
    public GalleryEntity querySingle(String galleryId) {
        return galleryMapper.querySingle(galleryId);
    }

    @Override
    public void insert(GalleryEntity galleryEntity) {
        galleryMapper.insert(galleryEntity);
    }

    @Override
    public void update(GalleryEntity galleryEntity) {
        galleryMapper.update(galleryEntity);
    }

    @Override
    public void delete(String galleryId) {
        galleryMapper.delete(galleryId);
    }
}
