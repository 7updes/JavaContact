package contact.dao.impl;

import contact.dao.PlaceDao;
import contact.model.Contact;

import contact.model.Place;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
@Repository
public class PlaceDaoImpl implements PlaceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addPlace(Place place) {
        sessionFactory.getCurrentSession().save(place);
    }

    @Override
    public Set<Contact> getAllContactsForPlace(Place place) {
        return null;
    }

    @Override
    @Transactional
    public List<Place> getAllPlaces() {
        return sessionFactory.getCurrentSession().createQuery("FROM Place").list();
    }

    @Override
    @Transactional
    public Place getPlaceById(int id) {
        Place place = (Place) sessionFactory.getCurrentSession().get(Place.class, id);
        return place;
    }
}

