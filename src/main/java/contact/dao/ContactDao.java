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
    public void deleteContact(Contact contact) throws SQLException;
    public void addFriendShip(Contact c1, Contact c2) throws SQLException;
    public void removeFriendShip(Contact c1, Contact c2)throws SQLException;
}
