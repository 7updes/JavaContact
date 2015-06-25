package contact.dao.impl;

import contact.dao.ContactDao;
import contact.model.Contact;
import contact.model.Hobby;


import java.util.*;
import contact.model.Place;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




/**
 * Created by Alex on 11.03.2015.
 */
@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private  SessionFactory sessionFactory;


    @Override
    public List<Contact> getAllContact() {
        return sessionFactory.getCurrentSession().createQuery("FROM Contact").list();
    }

    @Override
    public void saveContact(Contact contact){
        sessionFactory.getCurrentSession().persist(contact);
    }

    @Override
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @Override
    public void deleteContact(Contact contact){
       sessionFactory.getCurrentSession().delete(contact);
    }

    @Override
    public void addFriendShip(Contact contact, Contact contact2) {
        contact.getFriends().add(contact2);
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @Override
    public void addHobbyToContact(Contact contact, Hobby hobby) {
        contact.getHobbies().add(hobby);
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @Override
    public void addPlaceToContact(Contact contact, Place place) {
        contact.getPlaces().add(place);
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @Override
    public void removeFriendShip(Contact contact, Contact contact2) {
        contact.getFriends().remove(contact2);
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @Override
    public Contact getContactById(int id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
        return contact;
    }
}
