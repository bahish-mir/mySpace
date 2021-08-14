package controller;

import db.UsersDB;
import exception.NotFoundUserException;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = {"/authorization"})
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = UsersDB.selectOne(login, password);
        RequestDispatcher rd = null;

        try {
            if (user == null) {
                throw new NotFoundUserException("User not found by login");
            }
            //request.setAttribute("message", "You were successfully Logged In!!!");
            request.setAttribute("user", user);
            request.setAttribute("articles", user.getArticles());
            rd = request.getRequestDispatcher("view/main.jsp");

        } catch (NotFoundUserException e) {
            request.setAttribute("message", e.getMessage());
            rd = request.getRequestDispatcher("view/registration.jsp");
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        rd.forward(request, response);
    }
}
