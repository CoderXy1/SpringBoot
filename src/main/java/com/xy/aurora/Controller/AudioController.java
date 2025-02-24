package com.xy.aurora.Controller;

import com.xy.aurora.Common.Result.Result;
import com.xy.aurora.Common.Util.UuidGenerator;
import com.xy.aurora.Model.AudioEntity;
import com.xy.aurora.Service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Map;


@RestController
@RequestMapping("audio")
public class AudioController {

    @Autowired
    private AudioService audioService;

    @PostMapping("queryList")
    public Result queryList(@RequestBody Map<String,String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        String searchKey = map.get("searchKey");
        return Result.success(audioService.queryList(pageNum,pageSize,searchKey));
    }

    @PostMapping("querySingle")
    public Result querySingle(@RequestParam("audioId") String audioId) {
        return Result.success(audioService.querySingle(audioId));
    }

    @PostMapping("insert")
    public Result insert(@RequestParam("audioName") String audioName,@RequestParam("singer") String singer,@RequestParam("isLove")short isLove,@RequestParam("fileID") String fileID) {

        String audioId = UuidGenerator.generateUuid();
        AudioEntity audioEntity = new AudioEntity();
        audioEntity.setAudioId(audioId);
        audioEntity.setFileId(fileID);
        audioEntity.setAudioName(audioName);
        audioEntity.setSinger(singer);
        audioEntity.setIsLove(isLove);
        audioEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        audioService.insert(audioEntity);

        return Result.success();
    }

    @PostMapping("update")
    public Result update(@RequestBody Map<String,String> map) {

        String audioId = map.get("audioId");
        AudioEntity audioEntity = new AudioEntity();
        audioEntity.setAudioId(audioId);
        audioEntity.setAudioName(map.get("audioName"));
        audioEntity.setSinger(map.get("singer"));
        audioEntity.setIsLove(Short.parseShort(map.get("isLove")));
        audioService.update(audioEntity);

        return Result.success();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam("audioId") String audioId) {
        audioService.delete(audioId);
        return Result.success();
    }


}
