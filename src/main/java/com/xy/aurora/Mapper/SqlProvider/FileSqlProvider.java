package com.xy.aurora.Mapper.SqlProvider;

import com.xy.aurora.Model.FileEntity;
import org.apache.ibatis.annotations.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class FileSqlProvider {

    public String queryList(int pageNum, int pageSize, String fileType, Date startDate, Date endDate,String fileName) throws ParseException {

        StringBuilder sb = new StringBuilder("select * from file where 1 = 1");

        if (fileType != null && !fileType.isEmpty()){
            sb.append(" and FileType like CONCAT('%',#{fileType},'%')");
        }
        if (fileName != null && !fileName.isEmpty()){
            sb.append(" and FileName like CONCAT('%',#{fileName},'%')");
        }
        if (startDate != null && !startDate.toString().isEmpty()){
            sb.append(" and CreateDate >= #{startDate}");
        }
        if (endDate != null && !endDate.toString().isEmpty()){
            sb.append(" and CreateDate <= DATE_ADD(#{endDate}, INTERVAL 1 DAY)");
        }

        sb.append(" order by CreateDate desc limit #{pageSize} offset #{pageNum}");


        return sb.toString();
    }
}
