package contact.dao.impl;

import contact.dao.PlaceDao;
import contact.model.Contact;
import contact.model.Hobby;
import contact.model.Place;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 11.03.2015.
 */
@Repository
public class PlaceDaoImpl implements PlaceDao {

    private static final String url = "jdbc:mysql://localhost:3306/contactdb";
    private static String name = "root";
    private static String password = "root";
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public void addPlace(Place place) {
        try{
            connection = DriverManager.getConnection(url, name, password);
            String title = place.getTitle();
            if(place.getDescription()!=null){
                String description = place.getDescription();
                preparedStatement = connection.prepareStatement("INSERT INTO place (id, title, description) VALUES(?, ?, ?)");
                if(place.getId()!=0){
                    int id = place.getId();
                    preparedStatement.setInt(1, id);
                }else{
                    preparedStatement.setString(1, null);
                }
                preparedStatement.setString(3,description);
            }else {
                preparedStatement = connection.prepareStatement("INSERT INTO place (id, title) VALUES(?, ?)");
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
            place.setId(getPlaceId(place));
        }
    }

    @Override
    public Set<Contact> getAllContactsForPlace(Place place) {
        Set<Contact> contactsWithP = new HashSet<Contact>();
        String title = place.getTitle();
        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("SELECT c.id, c.first_name, c.last_name, c.birth_date, p.title from contact c, place p, contact_place cp where (cp.contact_id = c.id and cp.place_id = p.id) and p.title = ?;");
            preparedStatement.setString(1,title);
            ResultSet resultSet =  preparedStatement.executeQuery();

            while(resultSet.next()){
                Contact contact = new Contact();
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setBirthDate(resultSet.getDate(4));
                contactsWithP.add(contact);
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
        return contactsWithP;
    }

    @Override
    public int getPlaceId(Place place) {
        int placeId = 0;
        String title = place.getTitle();
        String description = place.getDescription();

        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("SELECT id FROM place where title = ? and description = ?");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                placeId = resultSet.getInt("id");
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
        return placeId;
    }
}

