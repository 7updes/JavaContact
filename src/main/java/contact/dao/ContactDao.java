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

    public void addContact(Contact contact) ;
    public void deleteContact(int id);
    public void deleteContactPlace(int contactId);
    public void deleteContactHobby(int contactId);
    public void deleteAllContactsFriends(int contactId);
    public void addFriendShip(int contact1Id, int contact2Id);
    public void removeFriendShip(int contact1Id, int contact2Id);
    public List<Contact> getAllContact();
    public int getContactId(Contact contact);
    public void addHobbyToContact(int contactId, int hobbyId);
    public void addPlaceToContact(int contactId, int placeId);
    public Set<Contact> getFriends (int contactId);

}
//CRUD