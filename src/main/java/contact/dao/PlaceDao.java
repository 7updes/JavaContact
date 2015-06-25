package contact.dao;

import contact.model.Contact;
import contact.model.Place;

import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public interface PlaceDao {
    void addPlace(Place place);
    Set<Contact> getAllContactsForPlace(Place place);
    Place getPlaceById (int id);
    List<Place> getAllPlaces();

}
