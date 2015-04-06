package contact.dao.impl;

import contact.dao.HobbyDao;
import contact.model.Contact;
import contact.model.Hobby;

import java.sql.*;
import java.util.*;

/**
 * Created by Alex on 11.03.2015.
 */
public class HobbyDaoImpl implements HobbyDao{
    private Set<Contact> allHobbies = new HashSet<Contact>();
    private static final String url = "jdbc:mysql://localhost:3306/contactdb";
    private static String name = "root";
    private static String password = "root";
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public HobbyDaoImpl() {
        try{
            connection = DriverManager.getConnection(url, name, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addHobby(Hobby hobby) {
        try{
            String title = hobby.getTitle();
            if(hobby.getDescription()!=null){
                String description = hobby.getDescription();
                preparedStatement = connection.prepareStatement("INSERT INTO hobby (id, title, description) VALUES(?, ?, ?)");
                preparedStatement.setString(1,null);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3,description);
                preparedStatement.executeUpdate();
            }else {
                preparedStatement = connection.prepareStatement("INSERT INTO hobby (id, title) VALUES(?, ?)");
                preparedStatement.setString(1,null);
                preparedStatement.setString(2, title);
                preparedStatement.executeUpdate();
            }


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
    }

    @Override
    public Set<Contact> getAllContactsWithHobby(Hobby hobby) {
        Set<Contact> contactsWithH = new HashSet<Contact>();
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select c.first_name, c.last_name, c.birth_date, h.title from contact c, hobby h, contact_hobby ch where ch.contact_id = c.id and ch.hobby_id = h.id;");
            while(resultSet.next()){
                if(resultSet.getString("title").equals(hobby.getTitle())){
                    Contact contact = new Contact();
                    contact.setFirstName(resultSet.getString("first_name"));
                    contact.setLastName(resultSet.getString("last_name"));
                    contact.setBirthDate(resultSet.getDate(4));
                    contactsWithH.add(contact);
                }
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
        return contactsWithH;
    }

    public int getHobbiesId (Hobby hobby){
        String title = hobby.getTitle();
        try{
            preparedStatement = connection.prepareStatement("SELECT id from hobby where title = ?;");
            preparedStatement.setString(1,title);
            ResultSet resultSet = preparedStatement.executeQuery();
            hobby.setId(resultSet.getInt("id"));

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
        return hobby.getId();
    }
}
