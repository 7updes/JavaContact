package contact.service;

import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Message;
import contact.model.Place;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public interface ContactService {
    void addContact(Contact contact);
    void saveContact(Contact contact);
    Contact getContactById (int id);
    Hobby addHobby(String title, String description);
    Place addPlace(String title, String description);
    void setPlaceToContact(Contact contact, Place place);
    void setHobbyToContact(Contact contact, Hobby hobby);
    void addFriendship(Contact c1, Contact c2);
    void removeFriendship(Contact c1, Contact c2);
    List<Contact> getFriendList(Contact contact);
    List<Message> getConversation(Contact c1, Contact c2);
    void sendMessage(String content, Contact from, Contact to);
    List<Contact> getAllContact();
    void deleteContactById(int id);
}
