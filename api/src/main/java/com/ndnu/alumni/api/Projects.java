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
       /* JSONObject object = new JSONObject();
        object.put("Hello", "world");
        String callback = "superfunction";
        String json = callback + "(" + object + ")";
        out.println(json);
        */
        String data = "";
        try
        {
            ProjectsBackend db = new ProjectsBackend();
            data = data + "yo";
            List<Project> project = db.getAllProjectNamesAndYears();
            if (project.size() == 0)
                data = data + "nothing";
            for (int i = 0; i < project.size(); i++)
            {
                data = data + i;
            }
            Project project1 = project.get(0);
            data = data + project1.getProjectName();
            data = data + project1.getProjectYear();
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
        PrintWriter out = response.getWriter();
        out.println("{success}");
    }
}
