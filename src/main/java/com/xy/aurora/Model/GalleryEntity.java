package com.xy.aurora.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "gallery", schema = "Aurora_new")
public class GalleryEntity {
    private String galleryId;
    private String galleryName;
    private String fileId;
    private Timestamp createDate;
    private Timestamp updateDate;
    private String galleryDescribe;
    private String fileName;
    private String fileUrl;

    @Id
    @Column(name = "GalleryId")
    public String getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(String galleryId) {
        this.galleryId = galleryId;
    }

    @Basic
    @Column(name = "GalleryName")
    public String getGalleryName() {
        return galleryName;
    }

    public void setGalleryName(String galleryName) {
        this.galleryName = galleryName;
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
    @Column(name = "GalleryDescribe")
    public String getGalleryDescribe() {
        return galleryDescribe;
    }

    public void setGalleryDescribe(String galleryDescribe) {
        this.galleryDescribe = galleryDescribe;
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
        GalleryEntity that = (GalleryEntity) o;
        return Objects.equals(galleryId, that.galleryId) && Objects.equals(galleryName, that.galleryName) && Objects.equals(fileId, that.fileId) && Objects.equals(createDate, that.createDate) && Objects.equals(galleryDescribe, that.galleryDescribe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(galleryId, galleryName, fileId, createDate, galleryDescribe);
    }
}
