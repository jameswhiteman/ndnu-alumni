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

import com.ndnu.alumni.db.UserStorage;
import com.ndnu.alumni.model.User;

public class Users extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        PrintWriter out = response.getWriter();

        // Get the request parameters.
        /*
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        */

        // Get the users from the database.
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        try
        {
            UserStorage store = new UserStorage();
            List<User> users = store.readUsers();
            response.setStatus(HttpServletResponse.SC_OK);
            Gson gson = new Gson();
            if (users != null)
            {
                out.println(gson.toJson(users));
            }
        }
        catch (SQLException e)
        {
            out.println("Failed to retrieve user from database.");
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
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int year = Integer.parseInt(request.getParameter("year"));
        String major = request.getParameter("major");
        String phone = request.getParameter("phone");
        String about = request.getParameter("about");
        String type = request.getParameter("type");

        // Add the user to the database.
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        try
        {
            UserStorage store = new UserStorage();
            store.createUser(first, last, email, password, type, year, major, phone, about);
            response.setStatus(HttpServletResponse.SC_CREATED);
            out.println("Successfully created user.");
        }
        catch (SQLException e)
        {
            out.println("Failed to create user.");
        }
    }
}
