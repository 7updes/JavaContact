package contact.dao.impl;

import contact.dao.HobbyDao;
import contact.model.Contact;
import contact.model.Hobby;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Alex on 11.03.2015.
 */
@Repository
public class HobbyDaoImpl implements HobbyDao{

    private static final String url = "jdbc:mysql://localhost:3306/contactdb";
    private static String name = "root";
    private static String password = "root";
    private Connection connection;
    private PreparedStatement preparedStatement;


    @Override
    public void addHobby(Hobby hobby) {
        try{
            connection = DriverManager.getConnection(url, name, password);
            String title = hobby.getTitle();
            if(hobby.getDescription()!=null){
                String description = hobby.getDescription();
                preparedStatement = connection.prepareStatement("INSERT INTO hobby (id, title, description) VALUES(?, ?, ?)");
                if(hobby.getId()!=0){
                    int id = hobby.getId();
                    preparedStatement.setInt(1, id);
                }else{
                    preparedStatement.setString(1, null);
                }
                preparedStatement.setString(3,description);
            }else {
                preparedStatement = connection.prepareStatement("INSERT INTO hobby (id, title) VALUES(?, ?)");
                preparedStatement.setString(1,null);
            }
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();


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
            hobby.setId(getHobbyId(hobby));
        }
    }

    @Override
    public Set<Contact> getAllContactsWithHobby(Hobby hobby) {
        Set<Contact> contactsWithH = new HashSet<Contact>();
        String title = hobby.getTitle();
        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("SELECT c.id, c.first_name, c.last_name, c.birth_date, h.title from contact c, hobby h, contact_hobby ch where (ch.contact_id = c.id and ch.hobby_id = h.id) and h.title = ?;");
            preparedStatement.setString(1,title);
            ResultSet resultSet =  preparedStatement.executeQuery();


            while(resultSet.next()){
                    Contact contact = new Contact();
                    contact.setFirstName(resultSet.getString("first_name"));
                    contact.setLastName(resultSet.getString("last_name"));
                    contact.setBirthDate(resultSet.getDate(4));
                    contactsWithH.add(contact);
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
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return contactsWithH;
    }

    @Override
    public int getHobbyId(Hobby hobby) {
        int hobbyId = 0;
        String title = hobby.getTitle();
        String description = hobby.getDescription();

        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("SELECT id FROM hobby where title = ? and description = ?");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                hobbyId = resultSet.getInt("id");
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
        return hobbyId;
    }


}
