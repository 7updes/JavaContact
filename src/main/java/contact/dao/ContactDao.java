package contact.dao;

import contact.model.Contact;

/**
 * Created by Alex on 11.03.2015.
 */
public interface ContactDao {
    public void addContact(Contact contact);
    public void deleteContact(Contact contact);
    public void addFriendShip(Contact c1, Contact c2);
    public void removeFriendShip(Contact c1, Contact c2);
}
