package com.xy.aurora.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "chat", schema = "Aurora_new", catalog = "")
public class ChatEntity {
    private String chatId;
    private String chatContent;
    private Timestamp chatTime;
    private String userType;

    @Id
    @Column(name = "ChatId")
    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    @Basic
    @Column(name = "ChatContent")
    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    @Basic
    @Column(name = "ChatTime")
    public Timestamp getChatTime() {
        return chatTime;
    }

    public void setChatTime(Timestamp chatTime) {
        this.chatTime = chatTime;
    }

    @Basic
    @Column(name = "UserType")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatEntity that = (ChatEntity) o;

        if (!Objects.equals(chatId, that.chatId)) return false;
        if (!Objects.equals(chatContent, that.chatContent)) return false;
        if (!Objects.equals(chatTime, that.chatTime)) return false;
        if (!Objects.equals(userType, that.userType)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chatId != null ? chatId.hashCode() : 0;
        result = 31 * result + (chatContent != null ? chatContent.hashCode() : 0);
        result = 31 * result + (chatTime != null ? chatTime.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }
}
