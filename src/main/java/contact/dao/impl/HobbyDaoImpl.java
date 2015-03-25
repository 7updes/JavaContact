package contact.dao.impl;

import contact.dao.HobbyDao;
import contact.model.Contact;
import contact.model.Hobby;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public class HobbyDaoImpl implements HobbyDao{

    Set<Hobby> setHobbies = new HashSet<Hobby>();

    @Override
    public void addHobby(Hobby hobby) {
        setHobbies.add(hobby);
    }


    @Override
    public Set<Contact> getAllContactsWithHobby(Hobby hobby) {
        Set<Contact> allWithHobby = new HashSet<Contact>();
        for (Map.Entry entry : ContactDaoImpl.idMap.entrySet()){
            allWithHobby.add((Contact)entry.getValue());
        }
        Set<Contact> allWithSameHobby = new HashSet<Contact>();
        for (Contact contact : allWithHobby){
            if(contact.getHobbies().contains(hobby)){
                allWithSameHobby.add(contact);
            }
        }
        return allWithSameHobby;
    }
}
