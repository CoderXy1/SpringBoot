package com.xy.aurora.Controller;

import com.xy.aurora.Common.Result.Result;
import com.xy.aurora.Common.Util.FileUpload;
import com.xy.aurora.Common.Util.UuidGenerator;
import com.xy.aurora.Model.FileEntity;
import com.xy.aurora.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("file")
public class FileController {

    @Value("${my.uploadImgPath}")
    private String uploadImgPath;
    @Value("${my.uploadFilePath}")
    private String uploadFilePath;
    @Value("${my.uploadImgUrl}")
    private String uploadImgUrl;
    @Value("${my.uploadFileUrl}")
    private String uploadFileUrl;
    @Autowired
    private FileService fileService;

    @PostMapping("queryList")
    public Result queryList(@RequestBody Map<String,String> map) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        String fileType = map.get("fileType");
        String fileName = map.get("fileName");
        Date startDate = null;
        Date endDate = null;
        if (map.get("startDate") != null && !map.get("startDate").isEmpty()){
            startDate = formatter.parse(map.get("startDate"));
        }
        if (map.get("endDate") != null && !map.get("endDate").isEmpty()){
            endDate = formatter.parse(map.get("endDate"));
        }
        return Result.success(fileService.queryList(pageNum,pageSize,fileType,startDate,endDate,fileName));
    }

    @PostMapping("queryTypes")
    public Result queryTypes() {
        return Result.success(fileService.queryTypes());
    }

    @PostMapping("insert")
    public Result insert(@RequestParam("file") MultipartFile file) {
        String destPath = "";
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String contentType = file.getContentType();

        String fileID = UuidGenerator.generateUuid();
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileId(fileID);
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setFileType(file.getContentType());
        fileEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));

        if (contentType != null && (contentType.startsWith("image/"))) {
            fileEntity.setFileUrl(uploadImgUrl + "/" + sdf.format(now) + "/" + file.getOriginalFilename());
            destPath = Paths.get(uploadImgPath, sdf.format(now)).resolve(file.getOriginalFilename()).toString();
        }else {
            fileEntity.setFileUrl(uploadFileUrl + "/" + sdf.format(now) + "/" + file.getOriginalFilename());
            destPath = Paths.get(uploadFilePath, sdf.format(now)).resolve(file.getOriginalFilename()).toString();
        }
        //上传文件到服务器
        if (FileUpload.FileUpload(file,destPath)){
            //添加File表
            fileService.insert(fileEntity);
        }else {
            return Result.fail(500,"文件上传失败!");
        }
        return Result.success(fileID);
    }

    @PostMapping("insertList")
    public Result insertList(@RequestParam("fileList[]") MultipartFile[] fileList) {
        String destPath = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String fileID = "";
        String contentType = "";
        for (MultipartFile file : fileList){
            Date now = new Date();
            fileID = UuidGenerator.generateUuid();
            contentType = file.getContentType();

            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileId(fileID);
            fileEntity.setFileName(file.getOriginalFilename());
            fileEntity.setFileType(file.getContentType());
            fileEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));

            if (contentType != null && (contentType.startsWith("image/"))) {
                fileEntity.setFileUrl(uploadImgUrl + "/" + sdf.format(now) + "/" + file.getOriginalFilename());
                destPath = Paths.get(uploadImgPath, sdf.format(now)).resolve(file.getOriginalFilename()).toString();
            }else {
                fileEntity.setFileUrl(uploadFileUrl + "/" + sdf.format(now) + "/" + file.getOriginalFilename());
                destPath = Paths.get(uploadFilePath, sdf.format(now)).resolve(file.getOriginalFilename()).toString();
            }
            //上传文件到服务器
            if (FileUpload.FileUpload(file,destPath)){
                //添加File表
                fileService.insert(fileEntity);
            }else {
                return Result.fail(500,"文件上传失败!" + file.getOriginalFilename());
            }
        }

        return Result.success();
    }


}
