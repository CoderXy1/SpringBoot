package com.xy.aurora.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "audio", schema = "Aurora_new", catalog = "")
public class AudioEntity {
    private String audioId;
    private String audioName;
    private String singer;
    private Short isLove;
    private String fileId;
    private Timestamp createDate;
    private Timestamp updateDate;
    private String fileName;
    private String fileUrl;

    @Id
    @Column(name = "AudioId")
    public String getAudioId() {
        return audioId;
    }

    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    @Basic
    @Column(name = "AudioName")
    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    @Basic
    @Column(name = "Singer")
    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Basic
    @Column(name = "IsLove")
    public Short getIsLove() {
        return isLove;
    }

    public void setIsLove(Short isLove) {
        this.isLove = isLove;
    }

    @Basic
    @Column(name = "FileId")
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "CreateDate")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "UpdateDate")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AudioEntity that = (AudioEntity) o;

        if (!Objects.equals(audioId, that.audioId)) return false;
        if (!Objects.equals(audioName, that.audioName)) return false;
        if (!Objects.equals(singer, that.singer)) return false;
        if (!Objects.equals(isLove, that.isLove)) return false;
        if (!Objects.equals(fileId, that.fileId)) return false;
        if (!Objects.equals(createDate, that.createDate)) return false;
        if (!Objects.equals(updateDate, that.updateDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = audioId != null ? audioId.hashCode() : 0;
        result = 31 * result + (audioName != null ? audioName.hashCode() : 0);
        result = 31 * result + (singer != null ? singer.hashCode() : 0);
        result = 31 * result + (isLove != null ? isLove.hashCode() : 0);
        result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }
}
