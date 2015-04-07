package contact.dao.impl;

import contact.dao.MessageDao;
import contact.model.Contact;
import contact.model.Message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


/**
 * Created by Alex on 11.03.2015.
 */
public class MessageDaoImpl implements MessageDao {

    private static final String url = "jdbc:mysql://localhost:3306/contactdb";
    private static String name = "root";
    private static String password = "root";
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public void storeMessage(Message message) {

        Date messageTime = message.getDate();
        String content = message.getContent();
        int contactIdFrom = message.getContactIdFrom();
        int contactIdTo = message.getContactIdTo();

        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("INSERT INTO message values(?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, 0);
            preparedStatement.setDate(2, new java.sql.Date(messageTime.getTime()));
            preparedStatement.setString(3, content);
            preparedStatement.setInt(4, contactIdFrom);
            preparedStatement.setInt(5, contactIdTo);
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

    @Override
    public List<Message> getConversation(Contact c1, Contact c2) {
        return null;
    }
}
