package contact.dao;

import contact.model.Contact;
import contact.model.Place;

import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
public interface PlaceDao {
    public void addPlace(Place place);
    public Set<Contact> getAllContactsForPlace(Place place);
}
