package com.xy.aurora.Controller;

import com.xy.aurora.Common.Result.Result;
import com.xy.aurora.Common.Util.UuidGenerator;
import com.xy.aurora.Model.GalleryEntity;
import com.xy.aurora.Model.NoteEntity;
import com.xy.aurora.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Map;


@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("queryList")
    public Result queryList(@RequestBody Map<String,String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        String searchKey = map.get("searchKey");
        return Result.success(noteService.queryList(pageNum,pageSize,searchKey));
    }

    @PostMapping("querySingle")
    public Result querySingle(@RequestParam("noteId") String noteId) {
        return Result.success(noteService.querySingle(noteId));
    }

    @PostMapping("insert")
    public Result insert(@RequestBody Map<String,String> map) {

        String noteId = UuidGenerator.generateUuid();
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setNoteId(noteId);
        noteEntity.setNoteTitle(map.get("noteTitle"));
        noteEntity.setContent(map.get("content"));
        noteEntity.setNoteColor(map.get("noteColor"));
        noteEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        noteService.insert(noteEntity);

        return Result.success();
    }

    @PostMapping("update")
    public Result update(@RequestBody Map<String,String> map) {

        String noteId = map.get("noteId");
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setNoteId(noteId);
        noteEntity.setNoteTitle(map.get("noteTitle"));
        noteEntity.setContent(map.get("content"));
        noteEntity.setNoteColor(map.get("noteColor"));
        noteService.update(noteEntity);

        return Result.success();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam("noteId") String noteId) {
        noteService.delete(noteId);
        return Result.success();
    }


}
