package com.ndnu.alumni.db;

import com.ndnu.alumni.model.*;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class NDNUAlumni
{
    private String host = "jdbc:mysql://localhost:3306";
    private String user = "root";
    private String password = "american";

    private Connection connection;

    public NDNUAlumni() throws SQLException
    {
        String url = host + "?user=" + user + "&password=" + password;
        Connection connection = DriverManager.getConnection(this.host);
    }
/*
    public List<Project> getProjects()
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        if (statement.execute("select * from "))
        {
            resultSet = statement.getResultSet();
        }
        if (resultSet == null)
        {
            return null;
        }
        while (resultSet.next())
        {

        }
    }
    */
}
