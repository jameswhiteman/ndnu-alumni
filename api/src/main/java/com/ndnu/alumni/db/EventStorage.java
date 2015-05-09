

package com.ndnu.alumni.db;

//Import Directives
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

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormat;

//import jdbc_session3.DBConnection;
//
import static com.ndnu.alumni.model.User.Major;

public class EventStorage
{
    ////Data Members////
    private Connection connection;

    ////Constructors////
    /**
     * Method Description: Creates a new ProjectsBackend object on instantiation
     * and gets a connection to the database.
     */
    public EventStorage() throws SQLException
    {
        DBConnection dbc = new DBConnection();
        connection = dbc.getConnection();

        // Use the default DB.
        Statement statement = connection.createStatement();
        String query = "use ndnualumni;";
        statement.executeQuery(query);
    }

    public void createEvent(String title, String type, String organizer, String major, String topic, String description, String time) throws SQLException
    {
        String query = "insert into events (EventTitle,EventType,EventOrgName,EventMajor,EventTopic,EventDesc,EventTime) values (?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, title);
        statement.setString(2, type);
        statement.setString(3, organizer);
        statement.setString(4, major);
        statement.setString(5, topic);
        statement.setString(6, description);
        statement.setString(7, time);
        /*
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        String newTime = formatter.print(Long.parseLong(time, 10));
        statement.setString(7, newTime);
        */
        statement.executeUpdate();
    }

    // Read events
    public List<Event> readEvents() throws SQLException
    {
        String query = "select * from events";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<Event> events = new ArrayList<Event>();
        while (resultSet.next())
        {
            String id = resultSet.getInt(1) + "";
            String title = resultSet.getString(2);
            String type = resultSet.getString(3);
            String organizer = resultSet.getString(4);
            String rawMajor = resultSet.getString(5);
            String topic = resultSet.getString(6);
            String description = resultSet.getString(7);
            long time = resultSet.getLong(8);
            Major major = User.getMajorForString(rawMajor);

            // Parse the correct date
            /*
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SS");
            DateTime dt = formatter.parseDateTime(time);
            DateTime dt = new DateTime(time);
            */
            Event event = new Event(id, title, type, organizer, major, topic, description, time);
            events.add(event);
        }
        return events;
    }

    // Delete event
    public void deleteEvent(String id) throws SQLException
    {
        String query = "delete from events where EventID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        statement.executeUpdate();
    }
}
