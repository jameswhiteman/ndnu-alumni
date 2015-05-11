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

import com.ndnu.alumni.db.JobStorage;
import com.ndnu.alumni.model.Job;

public class Jobs extends HttpServlet
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
            JobStorage store = new JobStorage();
            List<Job> jobs = store.readJobs();
            Gson gson = new Gson();
            if (jobs != null)
            {
                out.println(gson.toJson(jobs));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            out.println("Failed to retrieve jobs from database.");
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
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String company = request.getParameter("company");
        String description = request.getParameter("description");

        // Add the project to the database.
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        try
        {
            JobStorage store = new JobStorage();
            store.createJob(title, type, company, description);
            response.setStatus(HttpServletResponse.SC_CREATED);
            out.println("Successfully created job.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            out.println("Failed to create job.");
        }
    }
}
