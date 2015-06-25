package contact.dao;

import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Place;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


/**
 * Created by Alex on 11.03.2015.
 */
public interface ContactDao {

    void addContact(Contact contact) ;
    void saveContact(Contact contact);
    void deleteContact(Contact contact);
    void addFriendShip(Contact contact, Contact contact2);
    void removeFriendShip(Contact contact, Contact contact2);
    List<Contact> getAllContact();
    void addHobbyToContact(Contact contact, Hobby hobby);
    void addPlaceToContact(Contact contact, Place place);
    Contact getContactById(int id);


}
