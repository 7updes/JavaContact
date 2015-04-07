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
        }
    }


    public void deleteContact(int id) throws SQLException {
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

                            //for deleteContact()
    public void deleteContactHobby(int contactId) throws SQLException {
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

                            //for deleteContact()
    public void deleteContactPlace(int contactId) throws SQLException {
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

                            //    follow
    public void addFriendShip(int contact1Id, int contact2Id) throws SQLException {
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

                             //   unfollow
    public void removeFriendShip(int contact1Id, int contact2Id) throws SQLException {
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



}
