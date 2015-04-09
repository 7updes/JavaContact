package contact.dao;

import contact.dao.impl.ContactDaoImpl;
import contact.dao.impl.HobbyDaoImpl;
import contact.dao.impl.MessageDaoImpl;
import contact.dao.impl.PlaceDaoImpl;
import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Message;
import contact.model.Place;
import contact.service.ContactService;
import contact.service.ContactServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 14.03.2015.
 */
public class App {
    public static void main(String[] args) throws SQLException {

        ContactService contactService = new ContactServiceImpl();

        Hobby dive = contactService.addHobby("Boxing", "WBO");
        Place bar = contactService.addPlace("chachacha", "Naked people");

        Contact vitalik = contactService.createContact("Vitaliy", "Klychko", new Date(88, 00, 17));
        Contact rita = contactService.createContact("Naomi", "Campbell", new Date(88, 00, 17));
        contactService.setHobbyToContact(vitalik, dive);
        contactService.setPlaceToContact(vitalik, bar);
        contactService.addFriendship(vitalik, rita);
        System.out.println(contactService.getFriendList(vitalik));
        contactService.sendMessage("Ne vse mogut smotret v zavtrashniy den", vitalik, rita);
        contactService.sendMessage("i ne govori", rita, vitalik);
        System.out.println(contactService.getConversation(vitalik, rita));


    }

}
