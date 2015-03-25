package contact.dao.impl;

import contact.dao.ContactDao;
import contact.model.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ContactDaoImplTest {

    ContactDaoImpl contactDao = new ContactDaoImpl() ;
    @Mock
    ContactDao contact123;

    Contact contact = new Contact();

    @Test
    public void testContact() throws Exception {
        contact123.addContact(contact);
        verify(contact123 , times(1)).addContact(contact);
    }

    Contact empty = new Contact();
    Contact friend = new Contact();


    @Test
    public void testAddContact() throws Exception {
        contactDao.addContact(empty);
        assertEquals(empty, contactDao.getFirstContact());
    }

    @Test
    public void testAddFriendShip() throws Exception {
        contactDao.addFriendShip(empty, friend);
        assertEquals(empty.getFriends().get(0),friend);
    }

    @Test
    public void testContains() throws Exception {
        assertFalse(contactDao.contains(empty));
        contactDao.addContact(empty);
        assertTrue(contactDao.contains(empty));
    }
}