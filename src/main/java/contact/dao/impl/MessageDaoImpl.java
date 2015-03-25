package contact.dao.impl;

import contact.dao.MessageDao;
import contact.model.Contact;
import contact.model.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alex on 11.03.2015.
 */
public class MessageDaoImpl implements MessageDao {

    List<Message> listMessage = new ArrayList<Message>();

    @Override
    public void storeMessage(Message message) {
        listMessage.add(message);
    }

    @Override
    public List<Message> getConversation(Contact c1, Contact c2) {
       return null;
    }
}
