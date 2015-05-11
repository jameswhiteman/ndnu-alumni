package com.ndnu.alumni.db;

import com.ndnu.alumni.model.Event;
import com.ndnu.alumni.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.List;
import java.util.ArrayList;

public class EventStorage
{
    ////Data Members////
    private DBConnection dbc;

    ////Constructors////
    /**
     * Method Description: Creates a new ProjectsBackend object on instantiation
     * and gets a connection to the database.
     */
    public EventStorage() throws SQLException
    {
        dbc = new DBConnection();
    }

    public void createEvent(String title, String type, String organizer, String major, String description, String time) throws SQLException
    {
        Connection connection = dbc.getConnection();
        String query = "insert into ndnualumni.events (EventTitle,EventType,EventOrgName,EventMajor,EventTopic,EventDesc,EventTime) values (?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, title);
        statement.setString(2, type);
        statement.setString(3, organizer);
        statement.setString(4, major);
        statement.setString(5, "");
        statement.setString(6, description);
        statement.setString(7, time);
        statement.executeUpdate();
        dbc.closeConnection();
    }

    public List<Event> readEvents() throws SQLException
    {
        Connection connection = dbc.getConnection();
        String query = "select * from ndnualumni.events order by EventTime desc";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<Event> events = new ArrayList<Event>();
        while (resultSet.next())
        {
            String id = resultSet.getInt(1) + "";
            String title = resultSet.getString(2);
            String type = resultSet.getString(3);
            String organizer = resultSet.getString(4);
            String major = resultSet.getString(5);
            String topic = resultSet.getString(6);
            String description = resultSet.getString(7);
            long time = resultSet.getLong(8);

            // Parse the correct date
            /*
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SS");
            DateTime dt = formatter.parseDateTime(time);
            DateTime dt = new DateTime(time);
            */
            Event event = new Event(id, title, type, organizer, major, topic, description, time);
            events.add(event);
        }
        dbc.closeConnection();
        return events;
    }

    // Delete event
    public void deleteEvent(String id) throws SQLException
    {
        Connection connection = dbc.getConnection();
        String query = "delete from ndnualumni.events where EventID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        statement.executeUpdate();
        dbc.closeConnection();
    }
}
