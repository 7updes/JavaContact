package contact.dao.impl;

import contact.dao.MessageDao;

import contact.model.Message;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


/**
 * Created by Alex on 11.03.2015.
 */
@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Message> getConversation(int contact1Id, int contact2Id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Message M  WHERE (M.contactIdFrom = :id1 AND M.contactIdTo = :id2) " +
                "OR (M.contactIdFrom = :id2 AND M.contactIdTo = :id1) ORDER BY message_time ASC ");
        query.setParameter("id1", contact1Id);
        query.setParameter("id2", contact2Id);

        return query.list();
    }

    @Override
    @Transactional
    public void storeMessage(Message message) {
        sessionFactory.getCurrentSession().saveOrUpdate(message);
    }
}
