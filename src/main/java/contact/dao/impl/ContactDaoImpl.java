package contact.dao.impl;

import contact.dao.ContactDao;
import contact.model.Contact;
import contact.model.Hobby;

import java.sql.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

import contact.model.Place;
import org.hibernate.SessionFactory;


/**
 * Created by Alex on 11.03.2015.
 */

public class ContactDaoImpl implements ContactDao {

    private List<Contact> allContacts = new ArrayList<Contact>();
    private static final String url = "jdbc:mysql://localhost:3306/contactdb";
    private static String name = "root";
    private static String password = "root";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;


    @Override
    public void addContact(Contact contact) {
        try {
            connection = DriverManager.getConnection(url, name, password);
            String firstName = contact.getFirstName();
            String lastName = contact.getLastName();
            if (contact.getBirthDate() != null) {
                Date birthDate = contact.getBirthDate();
                preparedStatement = connection.prepareStatement("INSERT INTO contact(id, first_name, last_name, birth_date) VALUES(?, ?, ?, ?)");
                if(contact.getId() != 0){
                    int id = contact.getId();
                    preparedStatement.setInt(1, id);
                }else {
                    preparedStatement.setString(1, null);
                }
                preparedStatement.setDate(4, new java.sql.Date(birthDate.getTime()));
            }else {
                preparedStatement = connection.prepareStatement("INSERT INTO contact(id, first_name, last_name) VALUES(?, ?, ?)");
                preparedStatement.setString(1, null);
            }
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            contact.setId(getContactId(contact));
        }
    }

    @Override
    public void deleteContact(int id){
        try {
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("delete from contact where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override                          //for deleteContact()
    public void deleteContactHobby(int contactId){
        try {
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("delete from contact_hobby where contact_id = ?;");
            preparedStatement.setInt(1, contactId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override                          //for deleteContact()
    public void deleteContactPlace(int contactId){
        try {
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("delete from contact_place where contact_id = ?;");
            preparedStatement.setInt(1, contactId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override                          //for deleteContact()
    public void deleteAllContactsFriends(int contactId){
        try {
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("delete from contact_friendship where contact_id = ?;");
            preparedStatement.setInt(1, contactId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override                          //    follow
    public void addFriendShip(int contact1Id, int contact2Id){
        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("INSERT INTO contact_friendship VALUES (?, ?);");
            preparedStatement.setInt(1, contact1Id);
            preparedStatement.setInt(2, contact2Id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override                          //   unfollow
    public void removeFriendShip(int contact1Id, int contact2Id){
        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("DELETE FROM contact_friendship WHERE (contact_id = ? and friend_id = ?) or (friend_id = ? and contact_id = ?);");
            preparedStatement.setInt(1, contact1Id);
            preparedStatement.setInt(2, contact2Id);
            preparedStatement.setInt(3, contact2Id);
            preparedStatement.setInt(4, contact1Id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Contact> getAllContact(){
        List<Contact> allContacts = new ArrayList<Contact>();
        try{
            connection = DriverManager.getConnection(url, name, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contact");

            while(resultSet.next()){
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setBirthDate(resultSet.getDate("birth_date"));
                allContacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection!=null){
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return allContacts;
    }

    @Override
    public int getContactId(Contact contact) {
        int contactId = 0;
        String firstName = contact.getFirstName();
        String lastName = contact.getLastName();
        Date birthDate = contact.getBirthDate();

        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("SELECT id FROM contact where first_name = ? and last_name = ? and birth_date = ?");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setDate(3, new java.sql.Date(birthDate.getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                contactId = resultSet.getInt("id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return contactId;
    }

    @Override
    public void addHobbyToContact(int contactId, int hobbyId) {
        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("INSERT INTO contact_hobby values(?, ?);");
            preparedStatement.setInt(1,contactId);
            preparedStatement.setInt(2, hobbyId);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void addPlaceToContact(int contactId, int placeId) {
        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("INSERT INTO contact_place values(?, ?);");
            preparedStatement.setInt(1, contactId);
            preparedStatement.setInt(2, placeId);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Set<Contact> getFriends(int contactId) {
        Set<Contact> friends = new HashSet<Contact>();
        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("select cf.friend_id, f.first_name, f.last_name, f.birth_date from contact c, contact f, contact_friendship cf where (cf.contact_id = c.id and f.id = cf.friend_id) and c.id = ?;");
            preparedStatement.setInt(1,contactId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Contact contact = new Contact();
                contact.setId(resultSet.getInt(1));
                contact.setFirstName(resultSet.getString(2));
                contact.setLastName(resultSet.getString(3));
                contact.setBirthDate(resultSet.getDate(4));
                friends.add(contact);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return friends;
    }
}
