package contact.dao;

import contact.dao.impl.ContactDaoImpl;
import contact.dao.impl.HobbyDaoImpl;
import contact.dao.impl.PlaceDaoImpl;
import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Place;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 14.03.2015.
 */
public class App {
    public static void main(String[] args) {

        ContactDaoImpl contactDao = new ContactDaoImpl();
        Hobby hobby = new Hobby("Football", "Sport");
        HobbyDaoImpl hobbyDao = new HobbyDaoImpl();

        System.out.println(hobbyDao.getHobbiesId(hobby));



    }

}
