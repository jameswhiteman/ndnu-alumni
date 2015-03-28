package com.ndnu.alumni.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndnu.alumni.db.ProjectsBackend;
import com.ndnu.alumni.model.Project;

public class Projects extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        PrintWriter out = response.getWriter();
        String data = "";
        try
        {
            ProjectsBackend db = new ProjectsBackend();
            List<Project> project = db.getAllProjectNamesAndYears();
            Project project1 = project.get(0);
            data = data + "Name:" + project1.getProjectName();
            data = data + "\nYear:" + project1.getProjectYear();
        }
        catch (SQLException e)
        {
            data = data + "sql exception";
        }
        out.print("callbackfunction{'endpoint':'" + data + "'}");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        PrintWriter out = response.getWriter();

        // Get the request parameters.
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String description = request.getParameter("description");

        // Add the project to the database.
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        try
        {
            ProjectsBackend store = new ProjectsBackend();
            store.createProject(id, name, year, description);
            response.setStatus(HttpServletResponse.SC_CREATED);
            out.println("Successfully created user.");
        }
        catch (SQLException e)
        {
            out.println("Failed to create user.");
        }
    }
}
