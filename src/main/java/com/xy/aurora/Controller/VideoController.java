package com.xy.aurora.Controller;

import com.xy.aurora.Common.Result.Result;
import com.xy.aurora.Common.Util.UuidGenerator;
import com.xy.aurora.Model.VideoEntity;
import com.xy.aurora.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Map;


@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("queryList")
    public Result queryList(@RequestBody Map<String,String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        String searchKey = map.get("searchKey");
        return Result.success(videoService.queryList(pageNum,pageSize,searchKey));
    }

    @PostMapping("querySingle")
    public Result querySingle(@RequestParam("videoId") String videoId) {
        videoService.updatePlayCount(videoId);
        return Result.success(videoService.querySingle(videoId));
    }

    @PostMapping("insert")
    public Result insert(@RequestParam("title") String title,@RequestParam("fileID") String fileID) {

        String videoId = UuidGenerator.generateUuid();
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setVideoId(videoId);
        videoEntity.setTitle(title);
        videoEntity.setFileId(fileID);
        videoEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        videoService.insert(videoEntity);

        return Result.success();
    }

    @PostMapping("update")
    public Result update(@RequestBody Map<String,String> map) {

        String videoId = map.get("videoId");
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setVideoId(videoId);
        videoEntity.setTitle(map.get("title"));
        videoService.update(videoEntity);

        return Result.success();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam("videoId") String videoId) {
        videoService.delete(videoId);
        return Result.success();
    }


}
