package contact.dao;

import contact.dao.impl.ContactDaoImpl;
import contact.model.Contact;

import java.time.LocalDate;
import java.util.Map;

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
