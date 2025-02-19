package com.xy.aurora.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "diary", schema = "Aurora_new", catalog = "")
public class DiaryEntity {
    private String diaryId;
    private String title;
    private String content;
    private String weather;
    private Integer temperature;
    private String fileId;
    private Timestamp createDate;
    private Timestamp updateDate;
    private String fileName;
    private String fileUrl;

    @Id
    @Column(name = "DiaryId")
    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "Weather")
    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Basic
    @Column(name = "Temperature")
    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
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

        DiaryEntity that = (DiaryEntity) o;

        if (!Objects.equals(diaryId, that.diaryId)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(content, that.content)) return false;
        if (!Objects.equals(weather, that.weather)) return false;
        if (!Objects.equals(temperature, that.temperature)) return false;
        if (!Objects.equals(fileId, that.fileId)) return false;
        if (!Objects.equals(createDate, that.createDate)) return false;
        if (!Objects.equals(updateDate, that.updateDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diaryId != null ? diaryId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (weather != null ? weather.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }
}
