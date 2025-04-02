package com.xy.aurora.Service;

import com.xy.aurora.Model.NoteEntity;

import java.util.List;

public interface NoteService {

    List<NoteEntity> queryList(int pageNum, int pageSize,String searchKey);

    Integer queryTotal();

    NoteEntity querySingle(String noteId);

    void insert(NoteEntity galleryEntity);

    void update(NoteEntity galleryEntity);

    void delete(String noteId);
}
