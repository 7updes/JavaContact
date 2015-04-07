package contact.service;

import contact.dao.ContactDao;
import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Message;
import contact.model.Place;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public class ContactServiceImpl implements ContactService {
    ContactDao dao;
    @Override
    public void createContact(String firstName, String secondName, LocalDate dateOfBirth) {
/*
        Contact contact = new Contact(firstName, secondName, dateOfBirth);
        dao.addContact(contact);
*/

    }

    @Override
    public void addHobby(String title, String description) {

    }

    @Override
    public void addPlace(String title, String description) {

    }

    @Override
    public void setPlaceToContact(Contact contact, Place place) {

    }

    @Override
    public void setYobbyToContact(Contact contact, Hobby hobby) {

    }

    @Override
    public void addFriendship(Contact c1, Contact c2) {

    }

    @Override
    public Set<Contact> getFriendList(Contact contact) {
        return null;
    }

    @Override
    public List<Message> getConversation(Contact c1, Contact c2) {
        return null;
    }
}
