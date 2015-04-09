package contact.dao.impl;

import contact.dao.MessageDao;
import contact.model.Contact;
import contact.model.Message;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

        LocalDateTime messageTime = message.getDate();
        String content = message.getContent();
        int contactIdFrom = message.getContactIdFrom();
        int contactIdTo = message.getContactIdTo();

        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("INSERT INTO message values(?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, 0);
            preparedStatement.setTimestamp(2, Timestamp.valueOf(messageTime));
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
    public List<Message> getConversation(int contact1Id, int contact2Id) {
        List<Message> conversation = new ArrayList<Message>();
        try{
            connection = DriverManager.getConnection(url, name, password);
            preparedStatement = connection.prepareStatement("SELECT * from MESSAGE where (CONTACT_FROM_ID = ? and CONTACT_TO_ID = ?) or (CONTACT_FROM_ID = ? and CONTACT_TO_ID = ?) order by message_time asc;");
            preparedStatement.setInt(1,contact1Id);
            preparedStatement.setInt(2,contact2Id);
            preparedStatement.setInt(3,contact2Id);
            preparedStatement.setInt(4,contact1Id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Message message = new Message();
                message.setId(resultSet.getInt("id"));
                message.setDate(resultSet.getTimestamp("message_time").toLocalDateTime());
                message.setContent(resultSet.getString("content"));
                message.setContactIdFrom(resultSet.getInt("contact_from_id"));
                message.setContactIdTo(resultSet.getInt("contact_to_id"));
                conversation.add(message);
            }

        }catch (SQLException e ){
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
        return conversation;
    }
}
