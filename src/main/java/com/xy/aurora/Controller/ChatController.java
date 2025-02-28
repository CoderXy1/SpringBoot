package com.xy.aurora.Controller;

import com.xy.aurora.Common.Result.Result;
import com.xy.aurora.Common.Util.UuidGenerator;
import com.xy.aurora.Model.ChatEntity;
import com.xy.aurora.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Map;


@RestController
@RequestMapping("chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("queryList")
    public Result queryList(@RequestBody Map<String,String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        return Result.success(chatService.queryList(pageNum,pageSize));
    }

    @PostMapping("querySingle")
    public Result querySingle(@RequestParam("chatId") String chatId) {
        return Result.success(chatService.querySingle(chatId));
    }

    @PostMapping("insert")
    public Result insert(@RequestBody Map<String,String> map) {

        String chatId = UuidGenerator.generateUuid();
        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setChatId(chatId);
        chatEntity.setChatContent(map.get("chatContent"));
        chatEntity.setChatTime(new Timestamp(System.currentTimeMillis()));
        chatEntity.setUserType(map.get("userType"));
        chatService.insert(chatEntity);

        return Result.success();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam("chatId") String chatId) {
        chatService.delete(chatId);
        return Result.success();
    }


}
