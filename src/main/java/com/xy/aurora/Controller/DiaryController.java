package com.xy.aurora.Controller;

import com.xy.aurora.Common.Result.Result;
import com.xy.aurora.Common.Util.UuidGenerator;
import com.xy.aurora.Model.DiaryEntity;
import com.xy.aurora.Service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Map;


@RestController
@RequestMapping("diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @PostMapping("queryList")
    public Result queryList(@RequestBody Map<String,String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        String searchKey = map.get("searchKey");
        return Result.success(diaryService.queryList(pageNum,pageSize,searchKey));
    }

    @PostMapping("querySingle")
    public Result querySingle(@RequestParam("diaryId") String diaryId) {
        return Result.success(diaryService.querySingle(diaryId));
    }

    @PostMapping("insert")
    public Result insert(@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("luckyValue")int luckyValue,
                         @RequestParam("temperature") int temperature,@RequestParam("weather") String weather,@RequestParam("fileID") String fileID) {

        String diaryId = UuidGenerator.generateUuid();
        DiaryEntity diaryEntity = new DiaryEntity();
        diaryEntity.setDiaryId(diaryId);
        diaryEntity.setFileId(fileID);
        diaryEntity.setTitle(title);
        diaryEntity.setContent(content);
        diaryEntity.setTemperature(temperature);
        diaryEntity.setWeather(weather);
        diaryEntity.setLuckyValue(luckyValue);
        diaryEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        diaryService.insert(diaryEntity);

        return Result.success();
    }

    @PostMapping("update")
    public Result update(@RequestBody Map<String,String> map) {

        String diaryId = map.get("diaryId");
        DiaryEntity diaryEntity = new DiaryEntity();
        diaryEntity.setDiaryId(diaryId);
        diaryEntity.setTitle(map.get("title"));
        diaryEntity.setContent(map.get("content"));
        diaryEntity.setTemperature(Integer.parseInt(map.get("temperature")));
        diaryEntity.setLuckyValue(Integer.parseInt(map.get("luckyValue")));
        diaryEntity.setWeather(map.get("weather"));
        diaryService.update(diaryEntity);

        return Result.success();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam("diaryId") String diaryId) {
        diaryService.delete(diaryId);
        return Result.success();
    }


}
