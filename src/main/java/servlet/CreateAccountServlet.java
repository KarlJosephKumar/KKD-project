package servlet;

import model.HibernateMethods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CreateAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/CreateAccount.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateMethods hibernateMethods = HibernateMethods.getInstance();
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String nationality = req.getParameter("nationality");
        if(!hibernateMethods.checkIfUserExist(username)) {
            hibernateMethods.addAccount(username, password);
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                format.setTimeZone(TimeZone.getTimeZone("PST"));
                String date = req.getParameter("birthday");
                Date birthday = format.parse(date);
                hibernateMethods.addStudent(name, surname, birthday, nationality, username);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("login");
        } else {
            out.println("<html><head></head><body>");
            out.println("<b> Account already in exists!</b>");
            out.println("</BODY></HTML>");
//            resp.sendRedirect("create-account");
        }

    }
}
