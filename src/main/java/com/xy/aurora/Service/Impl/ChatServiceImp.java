package com.xy.aurora.Service.Impl;

import com.xy.aurora.Mapper.ChatMapper;
import com.xy.aurora.Model.ChatEntity;
import com.xy.aurora.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImp implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public List<ChatEntity> queryList(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return chatMapper.queryList(offset,pageSize);
    }

    @Override
    public ChatEntity querySingle(String chatId) {
        return chatMapper.querySingle(chatId);
    }

    @Override
    public void insert(ChatEntity chatEntity) {
        chatMapper.insert(chatEntity);
    }

    @Override
    public void delete(String chatId) {
        chatMapper.delete(chatId);
    }
}
