package com.ndnu.alumni.db;

import com.ndnu.alumni.model.Job;

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

public class JobStorage
{
    private Connection connection;

    public JobStorage() throws SQLException
    {
        DBConnection dbc = new DBConnection();
        connection = dbc.getConnection();
        Statement statement = connection.createStatement();
        String query = "use ndnualumni;";
        statement.executeQuery(query);
    }

    public void createJob(String title, String company, String type, String description) throws SQLException
    {
        String query = "insert into jobs (JobTitle,JobType,CompanyName,Description) values (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, title);
        statement.setString(2, type);
        statement.setString(3, company);
        statement.setString(4, description);
        statement.executeUpdate();
    }

    // Read events
    public List<Job> readJobs() throws SQLException
    {
        String query = "select * from jobs";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<Job> jobs = new ArrayList<Job>();
        while (resultSet.next())
        {
            String id = resultSet.getString(1);
            String title = resultSet.getString(3);
            String type = resultSet.getString(7);
            String company = resultSet.getString(4);
            String description = resultSet.getString(6);
            Job job = new Job(id, title, type, company, description);
            jobs.add(job);
        }
        return jobs;
    }
}
