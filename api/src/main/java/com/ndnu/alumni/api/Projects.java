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

import com.google.gson.Gson;

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
            List<Project> projects = db.getAllProjectNamesAndYears();
            Gson gson = new Gson();
            if (projects != null)
            {
                out.println(gson.toJson(projects));
            }
        }
        catch (SQLException e)
        {
            out.println("Failed to retrieve projects from database.");
        }
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
        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String description = request.getParameter("description");
        System.out.println("Name:" + name + "\nYear:" + year + "\nDesc:" + description);

        // Add the project to the database.
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        try
        {
            ProjectsBackend store = new ProjectsBackend();
            store.createProject(name, year, description);
            response.setStatus(HttpServletResponse.SC_CREATED);
            out.println("Successfully created project.");
        }
        catch (SQLException e)
        {
            out.println("Failed to create project.");
        }
    }
}
