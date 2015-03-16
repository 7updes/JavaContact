package contact.dao.impl;

import contact.dao.ContactDao;
import contact.model.Contact;
import org.springframework.stereotype.Component;

import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 11.03.2015.
 */

public class ContactDaoImpl implements ContactDao{

    private int numOfId = 0;
    public static Map<Integer, Contact> idMap = new HashMap<Integer,Contact>();


    @Override
    public void addContact(Contact contact) {
        numOfId+=1;
        contact.setId(numOfId);
        idMap.put(numOfId,contact);
    }

    @Override
    public void deleteContact(Contact contact) {

        Integer tmp = null;
        for (Map.Entry entry : idMap.entrySet()) {
            if(entry.getValue().equals(contact)){
                tmp = (Integer) entry.getKey();
                break;
            }
        }
        idMap.remove(tmp);
    }

    @Override
    public void addFriendShip(Contact c1, Contact c2) {

    }

    @Override
    public void removeFriendShip(Contact c1, Contact c2) {

    }

    public Contact getFirstContact(){
        return idMap.get(0);
    }
}
