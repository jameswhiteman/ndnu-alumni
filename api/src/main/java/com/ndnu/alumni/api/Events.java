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

import com.ndnu.alumni.db.EventStorage;
import com.ndnu.alumni.model.Event;

public class Events extends HttpServlet
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
            EventStorage store = new EventStorage();
            List<Event> events = store.readEvents();
            Gson gson = new Gson();
            if (events != null)
            {
                out.println(gson.toJson(events));
            }
        }
        catch (SQLException e)
        {
            out.println("Failed to retrieve events from database.");
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
        String organizer = request.getParameter("organizer");
        String major = request.getParameter("major");
        String description = request.getParameter("description");
        String time = request.getParameter("time");

        // Add the project to the database.
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        try
        {
            EventStorage store = new EventStorage();
            store.createEvent(title, type, organizer, major, description, time);
            response.setStatus(HttpServletResponse.SC_CREATED);
            out.println("Successfully created event.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            out.println("Failed to create event.");
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        super.doDelete(request, response);
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        PrintWriter out = response.getWriter();

        // Get the request parameters.
        String id = request.getParameter("id");

        // Add the project to the database.
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        try
        {
            EventStorage store = new EventStorage();
            store.deleteEvent(id);
            response.setStatus(HttpServletResponse.SC_OK);
            out.println("Successfully deleted event.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            out.println("Failed to delete event.");
        }
    }
}
