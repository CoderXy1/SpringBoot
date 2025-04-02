package com.xy.aurora.Service;

import com.xy.aurora.Model.GalleryEntity;

import java.util.List;

public interface GalleryService {

    List<GalleryEntity> queryList(int pageNum, int pageSize,String searchKey);

    Integer queryTotal();

    GalleryEntity querySingle(String galleryId);

    void insert(GalleryEntity galleryEntity);

    void update(GalleryEntity galleryEntity);

    void delete(String galleryId);
}
