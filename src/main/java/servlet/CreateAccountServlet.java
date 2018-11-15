package servlet;

import model.HibernateMethods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/CreateAccount.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateMethods hibernateMethods = HibernateMethods.getInstance();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String nationality = req.getParameter("nationality");

        hibernateMethods.addAccount(username, password);
        try {
            String[] date = req.getParameterValues("birthday");
            SimpleDateFormat bdaydate = new SimpleDateFormat("yyyy-mm-dd");
            Date birthday = bdaydate.parse(date[0]);
            hibernateMethods.addStudent(name, surname, birthday, nationality, username);
        } catch (ParseException e){
            e.printStackTrace();
        }

        resp.sendRedirect("login");


    }
}
