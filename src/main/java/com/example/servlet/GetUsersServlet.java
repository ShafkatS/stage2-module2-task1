package com.example.servlet;

import javax.servlet.annotation.WebServlet;
import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
     
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Set<User> userSet = Warehouse.getInstance().getUsers();
        req.setAttribute("users", userSet);
        req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
    }
    //write your code here!
}
