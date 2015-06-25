package contact.dao;

import contact.model.Contact;
import contact.model.Message;

import java.util.List;

/**
 * Created by Alex on 11.03.2015.
 */
public interface MessageDao {
    void storeMessage(Message message);
    List<Message> getConversation(int contact1Id, int contact2Id);
}
