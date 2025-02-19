package com.xy.aurora.Controller;

import com.xy.aurora.Common.Result.Result;
import com.xy.aurora.Common.Util.UuidGenerator;
import com.xy.aurora.Model.FileEntity;
import com.xy.aurora.Model.GalleryEntity;
import com.xy.aurora.Service.FileService;
import com.xy.aurora.Service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.Map;


@RestController
@RequestMapping("gallery")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;
    @Autowired
    private FileService fileService;

    @PostMapping("queryList")
    public Result queryList(@RequestBody Map<String,String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        String searchKey = map.get("searchKey");
        return Result.success(galleryService.queryList(pageNum,pageSize,searchKey));
    }

    @PostMapping("querySingle")
    public Result querySingle(@RequestParam("galleryId") String galleryId) {
        return Result.success(galleryService.querySingle(galleryId));
    }

    @PostMapping("insert")
    public Result insert(@RequestParam("galleryName") String galleryName,@RequestParam("galleryDescribe") String galleryDescribe,@RequestParam("fileID") String fileID) {

        String galleryId = UuidGenerator.generateUuid();
        GalleryEntity galleryEntity = new GalleryEntity();
        galleryEntity.setGalleryId(galleryId);
        galleryEntity.setFileId(fileID);
        galleryEntity.setGalleryName(galleryName);
        galleryEntity.setGalleryDescribe(galleryDescribe);
        galleryEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        galleryService.insert(galleryEntity);

        return Result.success();
    }

    @PostMapping("update")
    public Result update(@RequestBody Map<String,String> map) {

        String galleryId = map.get("galleryId");
        GalleryEntity galleryEntity = new GalleryEntity();
        galleryEntity.setGalleryId(galleryId);
        galleryEntity.setGalleryName(map.get("galleryName"));
        galleryEntity.setGalleryDescribe(map.get("galleryDescribe"));
        galleryService.update(galleryEntity);

        return Result.success();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam("galleryId") String galleryId) {
        galleryService.delete(galleryId);
        return Result.success();
    }


}
