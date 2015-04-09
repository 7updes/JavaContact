package contact.dao;

import contact.model.Contact;
import contact.model.Hobby;

import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public interface HobbyDao {
    public void addHobby(Hobby hobby);
    public Set<Contact> getAllContactsWithHobby(Hobby hobby);
    public int getHobbyId (Hobby hobby);
}
