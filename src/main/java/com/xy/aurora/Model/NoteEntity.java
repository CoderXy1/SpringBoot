package com.xy.aurora.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "note", schema = "Aurora_new", catalog = "")
public class NoteEntity {
    private String noteId;
    private String noteTitle;
    private String content;
    private String noteColor;
    private Timestamp createDate;
    private Timestamp updateDate;

    @Id
    @Column(name = "NoteId")
    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    @Basic
    @Column(name = "NoteTitle")
    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
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
    @Column(name = "NoteColor")
    public String getNoteColor() {
        return noteColor;
    }

    public void setNoteColor(String noteColor) {
        this.noteColor = noteColor;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteEntity that = (NoteEntity) o;

        if (!Objects.equals(noteId, that.noteId)) return false;
        if (!Objects.equals(noteTitle, that.noteTitle)) return false;
        if (!Objects.equals(content, that.content)) return false;
        if (!Objects.equals(noteColor, that.noteColor)) return false;
        if (!Objects.equals(createDate, that.createDate)) return false;
        if (!Objects.equals(updateDate, that.updateDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteId != null ? noteId.hashCode() : 0;
        result = 31 * result + (noteTitle != null ? noteTitle.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (noteColor != null ? noteColor.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }
}
