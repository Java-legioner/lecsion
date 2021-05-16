package ua.ivashchuk.servlet;

import ua.ivashchuk.domain.User;
import ua.ivashchuk.domain.UserRole;
import ua.ivashchuk.services.UserService;
import ua.ivashchuk.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    private UserService userService = UserServiceImpl.getUserService();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            try {
                userService.create(new User(firstName, lastName, email, UserRole.USER.toString(), password));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

       response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }
}
