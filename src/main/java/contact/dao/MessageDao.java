package contact.dao;

import contact.model.Contact;
import contact.model.Message;

import java.util.List;

/**
 * Created by Alex on 11.03.2015.
 */
public interface MessageDao {
    public void storeMessage(Message message);
    public List<Message> getConversation(Contact c1, Contact c2);
}
