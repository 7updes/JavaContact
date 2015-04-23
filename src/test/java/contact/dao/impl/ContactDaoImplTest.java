package contact.dao.impl;

import contact.dao.ContactDao;
import contact.model.Contact;
import contact.service.ContactService;
import contact.service.ContactServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import java.util.Collections;
import java.util.Date;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ContactDaoImplTest {

    @Mock
    ContactDao contactDao;
    @InjectMocks
    ContactServiceImpl contactServiceImpl;
    @Test
    public void testContactName(){
        Contact contact = new Contact("Ivan", "Ivanov", new Date());
        Contact contact1 = new Contact("Ivan", "Petrov", new Date());
        assertEquals(contact.getFirstName(), contact1.getFirstName());
    }


}