package com.xy.aurora.Service.Impl;

import com.xy.aurora.Mapper.NoteMapper;
import com.xy.aurora.Model.NoteEntity;
import com.xy.aurora.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImp implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public List<NoteEntity> queryList(int pageNum, int pageSize,String searchKey) {
        int offset = (pageNum - 1) * pageSize;
        return noteMapper.queryList(offset,pageSize,searchKey);
    }

    @Override
    public NoteEntity querySingle(String noteId) {
        return noteMapper.querySingle(noteId);
    }

    @Override
    public void insert(NoteEntity noteEntity) {
        noteMapper.insert(noteEntity);
    }

    @Override
    public void update(NoteEntity noteEntity) {
        noteMapper.update(noteEntity);
    }

    @Override
    public void delete(String noteId) {
        noteMapper.delete(noteId);
    }
}
