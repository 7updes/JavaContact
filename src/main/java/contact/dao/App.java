package contact.dao;

import contact.dao.impl.ContactDaoImpl;
import contact.dao.impl.HobbyDaoImpl;
import contact.dao.impl.PlaceDaoImpl;
import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Place;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 14.03.2015.
 */
public class App {
    public static void main(String[] args) {

        ContactDaoImpl contactDao = new ContactDaoImpl();

        Contact sasha = new Contact();
        sasha.setFirstName("sasha");
        sasha.setLastName("denysov");
        sasha.setBirthDate(LocalDate.of(1992, 6, 8));


        Contact viola = new Contact();
        viola.setFirstName("viola");
        viola.setLastName("serd");
        viola.setBirthDate(LocalDate.of(1994, 11, 8));

        Contact vova = new Contact();
        vova.setFirstName("vova");
        vova.setLastName("pivo");
        vova.setBirthDate(LocalDate.of(1958,11,8));

        contactDao.addContact(sasha);
        contactDao.addContact(viola);
        contactDao.addContact(vova);

        Hobby dance = new Hobby();
        dance.setTitle("dancing");
        dance.setDescription("put your hands in the air");
        Set<Hobby> girlHobbies = new HashSet<Hobby>();
        girlHobbies.add(dance);
        viola.setHobbies(girlHobbies);
        vova.setHobbies(girlHobbies);

        HobbyDao hobbyDao = new HobbyDaoImpl();
        System.out.println(hobbyDao.getAllContactsWithHobby(dance));

        Place cinema = new Place();
        cinema.setTitle("kinoshka");
        Set<Place> relax = new HashSet<Place>();
        relax.add(cinema);
        sasha.setPlaces(relax);
        viola.setPlaces(relax);

        PlaceDao placeDao = new PlaceDaoImpl();
        System.out.println(placeDao.getAllContactsForPlace(cinema));



        System.out.println(print());

        contactDao.deleteContact(viola);

        System.out.println(print());
    }
    public static String print() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Map.Entry<Integer,Contact> entry: ContactDaoImpl.idMap.entrySet()){
            int key = entry.getKey();
            String firstName = entry.getValue().getFirstName();
            String lastName  = entry.getValue().getLastName();
            stringBuilder.append(key).append(" - ").append(lastName).append(" ").append(firstName).append("\n");
        }
        return stringBuilder.toString();
    }

}
