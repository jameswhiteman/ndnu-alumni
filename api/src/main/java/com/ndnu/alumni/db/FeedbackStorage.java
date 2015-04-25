package com.ndnu.alumni.db;

import com.ndnu.alumni.model.Feedback;

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

public class FeedbackStorage
{
    private Connection connection;

    public FeedbackStorage() throws SQLException
    {
        DBConnection dbc = new DBConnection();
        connection = dbc.getConnection();
        Statement statement = connection.createStatement();
        String query = "use ndnualumni;";
        statement.executeQuery(query);
    }

    public void createFeedback(String id, String response1, String response2, String response3, String response4, String response5) throws SQLException
    {
        String query = "insert into feedback (UserID,QuestionOne,QuestionTwo,QuestionThree,QuestionFour,QuestionFive) values (?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        statement.setString(2, response1);
        statement.setString(3, response2);
        statement.setString(4, response3);
        statement.setString(5, response4);
        statement.setString(6, response5);
        statement.executeUpdate();
    }

    public List<Feedback> readFeedbacks() throws SQLException
    {
        String query = "select * from feedback";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<Feedback> feedbacks = new ArrayList<Feedback>();
        while (resultSet.next())
        {
            String id = resultSet.getInt(1) + "";
            String userId = resultSet.getInt(2) + "";
            String response1 = resultSet.getString(3);
            String response2 = resultSet.getString(4);
            String response3 = resultSet.getString(5);
            String response4 = resultSet.getString(6);
            String response5 = resultSet.getString(7);
            Feedback feedback = new Feedback(id, userId, response1, response2, response3, response4, response5);
            feedbacks.add(feedback);
        }
        return feedbacks;
    }
}
