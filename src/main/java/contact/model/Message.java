package contact.model;





import javax.persistence.*;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Alex on 09.03.2015.
 */
@Entity
@Table(name = "message")
public class Message {
    @Column(name = "id")
    private int id;
    @Column(name = "message_time")
    private LocalDateTime date;
    @Column(name = "contact_from_id")
    private int contactIdFrom;
    @Column(name = "contact_to_id")
    private int contactIdTo;
    @Column(name = "content")
    private String content;

    public Message() {
    }

    public Message( LocalDateTime date, String content, int contactIdFrom, int contactIdTo) {
        this.date = date;
        this.content = content;
        this.contactIdFrom = contactIdFrom;
        this.contactIdTo = contactIdTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getContactIdFrom() {
        return contactIdFrom;
    }

    public void setContactIdFrom(int contactIdFrom) {
        this.contactIdFrom = contactIdFrom;
    }

    public int getContactIdTo() {
        return contactIdTo;
    }

    public void setContactIdTo(int contactIdTo) {
        this.contactIdTo = contactIdTo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content +" \n";
    }
}
