package com.xy.aurora.Common.Util;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;



public class FileUpload {
    private static final long MAX_FILE_SIZE = 3 * 1024 * 1024; // 3MB
    public static boolean FileUpload(MultipartFile file,String uploadPath) {

        if (file.isEmpty() || uploadPath.isEmpty()) {
            return false;
        }

        try {
            File saveFile = new File(uploadPath);
            if (!saveFile.exists()){
                saveFile.mkdirs();
            }

            file.transferTo(saveFile);

            //压缩图片
            if (saveFile.length() > MAX_FILE_SIZE && file.getContentType().startsWith("image/")){
                Thumbnails.of(saveFile)
                        .scale(1.0) // 缩放比例，例如0.5表示缩小到原图的50%
                        .outputQuality(0.75f) // 设置输出质量，范围从0.0到1.0，1.0为最高质量
                        .toFile(saveFile);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
