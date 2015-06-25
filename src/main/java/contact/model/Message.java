package contact.model;





import javax.persistence.*;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 09.03.2015.
 */
@Entity
@Table(name = "MESSAGE")
public class Message implements Serializable{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "MESSAGE_TIME")
    private Timestamp date;
    @Column(name = "CONTACT_FROM_ID")
    private int contactIdFrom;
    @Column(name = "CONTACT_TO_ID")
    private int contactIdTo;
    @Column(name = "CONTENT")
    private String content;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "allConversation")
    private List<Contact> conversation = new LinkedList<>();


    public Message() {
    }

    public Message( Timestamp date, String content, int contactIdFrom, int contactIdTo) {
        this.date = date;
        this.content = content;
        this.contactIdFrom = contactIdFrom;
        this.contactIdTo = contactIdTo;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(java.sql.Timestamp date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Contact> getConversation() {
        return conversation;
    }

    public void setConversation(List<Contact> conversation) {
        this.conversation = conversation;
    }

    @Override
    public String toString() {
        return "Message{" +
                "contactIdFrom=" + contactIdFrom +
                ", id=" + id +
                ", date=" + date +
                ", contactIdTo=" + contactIdTo +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (contactIdFrom != message.contactIdFrom) return false;
        if (contactIdTo != message.contactIdTo) return false;
        if (date != null ? !date.equals(message.date) : message.date != null) return false;
        return !(content != null ? !content.equals(message.content) : message.content != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + contactIdFrom;
        result = 31 * result + contactIdTo;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
