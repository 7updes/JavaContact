package contact.dao;

import contact.model.Contact;
import contact.model.Hobby;

import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public interface HobbyDao {
    void addHobby(Hobby hobby);
    Set<Contact> getAllContactsWithHobby(Hobby hobby);
    Hobby getHobbyById (int id);
    List<Hobby> getAllHobbies();
}
