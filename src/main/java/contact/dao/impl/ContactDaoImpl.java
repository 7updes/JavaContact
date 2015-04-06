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

public class ContactDaoImpl implements ContactDao{

    private List<Contact> allContacts = new ArrayList<Contact>();
    private static final String url = "jdbc:mysql://localhost:3306/contactdb";
    private static String name = "root";
    private static String password = "root";
    private  Connection connection;
    private PreparedStatement preparedStatement;

    public ContactDaoImpl() {
        try{
            connection = DriverManager.getConnection(url, name, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addContact(Contact contact){
        try{
            String firstName = contact.getFirstName();
            String lastName = contact.getLastName();
            if(contact.getBirthDate()!=null){
                Date birthDate = contact.getBirthDate();
                //incorrect date value
                preparedStatement = connection.prepareStatement("INSERT INTO contact(id, first_name, last_name, birth_date) VALUES(?, ?, ?, ?)");
                preparedStatement.setString(1,null);
                preparedStatement.setString(2,firstName);
                preparedStatement.setString(3,lastName);
                preparedStatement.setString(4, String.valueOf(birthDate));
                System.out.println(String.valueOf(birthDate));
                preparedStatement.executeUpdate();
            }else {
                preparedStatement = connection.prepareStatement("INSERT INTO contact(id, first_name, last_name) VALUES(?, ?, ?)");
                preparedStatement.setString(1,null);
                preparedStatement.setString(2,firstName);
                preparedStatement.setString(3,lastName);
                preparedStatement.executeUpdate();
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
    }

    public void deleteContact(Contact contact) throws SQLException{
        try{
            int id = new ContactDaoImpl().getContactId(contact);
            preparedStatement = connection.prepareStatement("delete from contact where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
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
    }


    public void addFriendShip(Contact c1, Contact c2) throws SQLException{

    }


    public void removeFriendShip(Contact c1, Contact c2) throws SQLException{

    }

    public int getContactId (Contact contact){
        String firstName = contact.getFirstName();
        String lastName = contact.getLastName();
        try{
            preparedStatement = connection.prepareStatement("SELECT id from contact where first_name = ? and last_name = ?;");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            contact.setId(resultSet.getInt("id"));

        } catch (SQLException e) {
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
        return contact.getId();
    }

}
