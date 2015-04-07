package contact.service;

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
public interface ContactService {
    public void createContact(String firstName, String secondName, LocalDate dateOfBirth);
    public void addHobby(String title, String description);
    public void addPlace(String title, String description);
    public void setPlaceToContact(Contact contact, Place place);
    public void setYobbyToContact(Contact contact, Hobby hobby);
    public void addFriendship(Contact c1, Contact c2);
    public Set<Contact> getFriendList(Contact contact);
    public List<Message> getConversation(Contact c1, Contact c2);
}
