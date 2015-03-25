package contact.dao.impl;

import contact.dao.PlaceDao;
import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Place;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public class PlaceDaoImpl implements PlaceDao {

    Set<Place> setPlaces = new HashSet<Place>();

    @Override
    public void addPlace(Place place) {
        setPlaces.add(place);
    }

    @Override
    public Set<Contact> getAllContactsForPlace(Place place) {

        Set<Contact> allWithPlace = new HashSet<Contact>();
        for (Map.Entry entry : ContactDaoImpl.idMap.entrySet()){
            allWithPlace.add((Contact)entry.getValue());
        }
        Set<Contact> allWithSamePlace = new HashSet<Contact>();
        for (Contact contact : allWithPlace){
            if(contact.getPlaces().contains(place)){
                allWithSamePlace.add(contact);
            }
        }
        return allWithSamePlace;
    }
}

