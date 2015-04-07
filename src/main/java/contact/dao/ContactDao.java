package contact.dao;

import contact.model.Contact;
import contact.model.Hobby;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Alex on 11.03.2015.
 */
public interface ContactDao {
    public void addContact(Contact contact) throws SQLException;
    public void deleteContact(int id) throws SQLException;
    public void addFriendShip(int contact1Id, int contact2Id) throws SQLException;
    public void removeFriendShip(int contact1Id, int contact2Id)throws SQLException;
}
//CRUD