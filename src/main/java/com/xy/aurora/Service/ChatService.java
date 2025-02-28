package com.xy.aurora.Service;


import com.xy.aurora.Model.ChatEntity;

import java.util.List;

public interface ChatService {

    List<ChatEntity> queryList(int pageNum, int pageSize);

    ChatEntity querySingle(String chatId);

    void insert(ChatEntity galleryEntity);

    void delete(String chatId);
}
