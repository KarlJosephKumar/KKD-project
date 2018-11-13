package servlet;

import hibernate.Login;
import model.HibernateMethods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class LoginServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/Login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HibernateMethods hibernateMethods = HibernateMethods.getInstance();

        if (hibernateMethods.loginCheck(username, password)) {

            Login userId = hibernateMethods.checkId(username);

            HttpSession session = req.getSession();
            String sessionKey = UUID.randomUUID().toString();
            session.setAttribute("sessionKey", sessionKey);
            hibernateMethods.addSession(userId, sessionKey);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/NavigationView.jsp");
            requestDispatcher.forward(req, resp);

        }

    }
}
