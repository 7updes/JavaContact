package contact.service;

import contact.dao.ContactDao;
import contact.dao.HobbyDao;
import contact.dao.MessageDao;
import contact.dao.PlaceDao;
import contact.dao.impl.ContactDaoImpl;
import contact.dao.impl.HobbyDaoImpl;
import contact.dao.impl.MessageDaoImpl;
import contact.dao.impl.PlaceDaoImpl;
import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Message;
import contact.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import sun.awt.AWTAccessor;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public class ContactServiceImpl implements ContactService {


    ContactDao contactDao = new ContactDaoImpl();

    HobbyDao hobbyDao = new HobbyDaoImpl();

    PlaceDao placeDao = new PlaceDaoImpl();

    MessageDao messageDao = new MessageDaoImpl();


    @Override
    public Contact createContact(String firstName, String secondName, Date dateOfBirth){

        Contact contact = new Contact(firstName, secondName, dateOfBirth);
        contactDao.addContact(contact);
        return contact;
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
    public void setPlaceToContact(Contact contact, Place place) {

        int contactId = contact.getId();
        int placeId = place.getId();
        contactDao.addPlaceToContact(contactId, placeId);
    }

    @Override
    public void setHobbyToContact(Contact contact, Hobby hobby) {

        int contactId = contact.getId();
        int hobbyId = hobby.getId();
        contactDao.addHobbyToContact(contactId,hobbyId);
    }

    @Override
    public void addFriendship(Contact c1, Contact c2) {
        int contact1Id = c1.getId();
        int contact2Id = c2.getId();
        contactDao.addFriendShip(contact1Id, contact2Id);
        contactDao.addFriendShip(contact2Id, contact1Id);
    }

    @Override
    public Set<Contact> getFriendList(Contact contact) {

        int contactId = contact.getId();
        return contactDao.getFriends(contactId);
    }

    @Override
    public List<Message> getConversation(Contact c1, Contact c2) {

        int contact1Id = c1.getId();
        int contact2Id = c2.getId();
        return messageDao.getConversation(contact1Id,contact2Id);
    }

    @Override
    public void sendMessage(String content, Contact from, Contact to) {

        int contactIfFrom = from.getId();
        int contactIdTo = to.getId();
        Message message = new Message(LocalDateTime.now(), content, contactIfFrom, contactIdTo);
        messageDao.storeMessage(message);
    }
}
