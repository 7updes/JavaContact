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

    ContactDao contactDao ;
    @InjectMocks
    Contact empty = new Contact();


    @Test
    public void testContactDaoImpl() throws Exception {



    }
}