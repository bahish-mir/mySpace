package controller;

import db.UsersDB;
import exception.NotFoundUserException;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
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
            if (user != null) {
                throw new NotFoundUserException("This user have already", login);
            }
            if (login.isEmpty() || password.isEmpty()) {
                throw new NotFoundUserException("Some params is empty!!!");
            }
            user = UsersDB.createUser(login, password);
            //request.setAttribute("message", "You were successfully registered!!!");
            request.setAttribute("user", user);
            request.setAttribute("articles", user.getArticles());
            rd = request.getRequestDispatcher("view/main.jsp");

        } catch (NotFoundUserException e) {
            request.setAttribute("message", e.getMessage());
            rd = request.getRequestDispatcher("view/notfound.jsp");
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        rd.forward(request, response);
    }
}
