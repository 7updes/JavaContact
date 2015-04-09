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
    public Contact createContact(String firstName, String secondName, Date dateOfBirth);
    public Hobby addHobby(String title, String description);
    public Place addPlace(String title, String description);
    public void setPlaceToContact(Contact contact, Place place);
    public void setHobbyToContact(Contact contact, Hobby hobby);
    public void addFriendship(Contact c1, Contact c2);
    public Set<Contact> getFriendList(Contact contact);
    public List<Message> getConversation(Contact c1, Contact c2);
    public void sendMessage(String content, Contact from, Contact to);
}
