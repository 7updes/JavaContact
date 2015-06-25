package contact.service;

import contact.dao.ContactDao;
import contact.dao.HobbyDao;
import contact.dao.MessageDao;
import contact.dao.PlaceDao;

import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Message;
import contact.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


/**
 * Created by Alex on 11.03.2015.
 */



@Transactional
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;
    @Autowired
    private HobbyDao hobbyDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private MessageDao messageDao;



    @Override
    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    @Override
    public void saveContact(Contact contact) {
        contactDao.saveContact(contact);
    }

    @Override
    public Contact getContactById(int id) {
        return contactDao.getContactById(id);
    }

    @Override
    public Hobby addHobby(String title, String description) {
        Hobby hobby = new Hobby(title, description);
        hobbyDao.addHobby(hobby);
        return hobby;
    }

    @Override
    public Place addPlace(String title, String description) {
        Place place = new Place(title, description);
        placeDao.addPlace(place);
        return place;
    }

    @Override
    public void addFriendship(Contact c1, Contact c2) {
        contactDao.addFriendShip(c1, c2);
        contactDao.addFriendShip(c2, c1);
    }

    @Override
    public void removeFriendship(Contact c1, Contact c2) {
        contactDao.removeFriendShip(c1, c2);
        contactDao.removeFriendShip(c2, c1);
    }

    @Override
    public List<Message> getConversation(Contact c1, Contact c2) {
        int id1 = c1.getId();
        int id2 = c2.getId();
        return messageDao.getConversation(id1, id2);
    }

    @Override
    public List<Contact> getFriendList(Contact contact) {
        return contact.getFriends();
    }

    @Override
    public void sendMessage(String content, Contact from, Contact to) {
        Message message = new Message(Timestamp.valueOf(LocalDateTime.now()), content, from.getId(), to.getId());
        messageDao.storeMessage(message);
    }

    @Override
    public void setHobbyToContact(Contact contact, Hobby hobby) {
        contactDao.addHobbyToContact(contact, hobby);
    }

    @Override
    public void setPlaceToContact(Contact contact, Place place) {
        contactDao.addPlaceToContact(contact, place);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactDao.getAllContact();
    }

    @Override
    public void deleteContactById(int id) {
        contactDao.deleteContact(contactDao.getContactById(id));

    }
}
