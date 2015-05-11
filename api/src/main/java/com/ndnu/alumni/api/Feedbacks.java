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

import com.ndnu.alumni.db.FeedbackStorage;
import com.ndnu.alumni.model.Feedback;

public class Feedbacks extends HttpServlet
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
            FeedbackStorage store = new FeedbackStorage();
            List<Feedback> feedbacks = store.readFeedbacks();
            Gson gson = new Gson();
            if (feedbacks != null)
            {
                out.println(gson.toJson(feedbacks));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            out.println("Failed to retrieve feedback from database.");
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
        String id = request.getParameter("userId");
        String response1 = request.getParameter("response1");
        String response2 = request.getParameter("response2");
        String response3 = request.getParameter("response3");
        String response4 = request.getParameter("response4");
        String response5 = request.getParameter("response5");

        // Add the project to the database.
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        try
        {
            FeedbackStorage store = new FeedbackStorage();
            store.createFeedback(id, response1, response2, response3, response4, response5);
            response.setStatus(HttpServletResponse.SC_CREATED);
            out.println("Successfully added feedback.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            out.println("Failed to add feedback.");
        }
    }
}
