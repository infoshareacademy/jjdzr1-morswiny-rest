package com.isa.morswiny.model;



import javax.persistence.*;

@Entity
@Table(name="attachment")
public class Attachment{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer attachmentId;
    private String fileName;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="event_Id", referencedColumnName = "eventId")
    private Event event;

    public Attachment (String fileName) {
        this.fileName = fileName;
    }

    public Attachment() {
    }

    @Override
    public String toString() {
        return "Attachment " +
                "file Name = " + fileName;
    }
    public Integer getAttachmentId() {
        return attachmentId;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}

