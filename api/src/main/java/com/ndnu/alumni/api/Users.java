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
        PrintWriter out = response.getWriter();
        out.println("get users");
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
        out.println("Yo0");
        String first = request.getParameter("first");
        out.println("Yo1");
        String last = request.getParameter("last");
        out.println("Yo2");
        String email = request.getParameter("email");
        out.println("Yo3");
        int year = Integer.parseInt(request.getParameter("year"));
        out.println("Yo4");
        String major = request.getParameter("major");
        out.println("Yo5");
        String phone = request.getParameter("phone");
        out.println("Yo6");
        String about = request.getParameter("about");
        out.println("Yo7");

        // Add the user to the database.
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        try
        {
            out.println("Yo8");
            UserStorage store = new UserStorage();
            out.println("Yo9");
            store.createUser(first, last, email, year, major, phone, about);
            out.println("Yo10");
            response.setStatus(HttpServletResponse.SC_CREATED);
            out.println("Successfully created user.");
        }
        catch (SQLException e)
        {
            out.println("Failed to create user.");
        }
    }
}
