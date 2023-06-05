package com.example.servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
     
     
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User user = new User(firstName, lastName);
        req.setAttribute("user", user);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.addUser(user);
        req.getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
    }
    //write your code here!
}
