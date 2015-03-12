package contact.service;

import contact.model.Contact;
import contact.model.Message;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public interface JavaContact {
    public void createContact(String firstName, String secondName, LocalDate dateOfBirth);
    public void addHobby(String title, String description);
    public void addPlace(String title, String description, double longitude, double latitude);
    public void addFriendship(Contact c1, Contact c2);
    public Set<Contact>getFriendList(Contact contact);
    public List<Message> getConversation(Contact c1, Contact c2);
}
