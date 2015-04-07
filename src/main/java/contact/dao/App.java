package contact.dao;

import contact.dao.impl.ContactDaoImpl;
import contact.dao.impl.HobbyDaoImpl;
import contact.dao.impl.MessageDaoImpl;
import contact.dao.impl.PlaceDaoImpl;
import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Message;
import contact.model.Place;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 14.03.2015.
 */
public class App {
    public static void main(String[] args) throws SQLException {

        ContactDaoImpl contactDao = new ContactDaoImpl();

//        HobbyDao hobbyDao = new HobbyDaoImpl();
//        PlaceDao placeDao = new PlaceDaoImpl();
//        Hobby hobby = new Hobby("Football", "Rugby");
//        Place place = new Place("Jackson", "night club");
//        placeDao.addPlace(place);
        Contact filip = new Contact("Phil", "Jagelka");
        Contact robert = new Contact("Robert", "Barateon");
        Message message = new Message(new Date(), "how are you doing", 9, 4);
        MessageDao messageDao = new MessageDaoImpl();
        messageDao.storeMessage(message);


    }

}
