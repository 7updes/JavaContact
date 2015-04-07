package contact.model;


import java.util.Date;

/**
 * Created by Alex on 09.03.2015.
 */
public class Message {

    private int id;
    private Date date;
    private int contactIdFrom;
    private int contactIdTo;
    private String content;


    public Message( Date date, String content, int contactIdFrom, int contactIdTo) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
