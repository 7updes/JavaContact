package contact.dao.impl;

import contact.dao.HobbyDao;
import contact.model.Contact;
import contact.model.Hobby;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;


/**
 * Created by Alex on 11.03.2015.
 */
@Repository
public class HobbyDaoImpl implements HobbyDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addHobby(Hobby hobby) {
        sessionFactory.getCurrentSession().save(hobby);
    }

    @Override
    public Set<Contact> getAllContactsWithHobby(Hobby hobby) {
        return hobby.getContacts();
    }

    @Override
    @Transactional
    public Hobby getHobbyById(int id) {
        Hobby hobby = (Hobby) sessionFactory.getCurrentSession().get(Hobby.class, id);
        return hobby;
    }

    @Override
    @Transactional
    public List<Hobby> getAllHobbies() {
        return sessionFactory.getCurrentSession().createQuery("FROM Hobby").list();
    }
}
