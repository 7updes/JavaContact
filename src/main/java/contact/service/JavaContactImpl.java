package contact.service;

import contact.model.Contact;
import contact.model.Message;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public class JavaContactImpl implements JavaContact{
    @Override
    public void createContact(String firstName, String secondName, LocalDate dateOfBirth) {

    }

    @Override
    public void addHobby(String title, String description) {

    }

    @Override
    public void addPlace(String title, String description, double longitude, double latitude) {

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
