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

public class NavigationViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateMethods hibernateMethods = HibernateMethods.getInstance();
        HttpSession session = req.getSession();
        Login userId = (Login) session.getAttribute("userId");

        if (hibernateMethods.checkForSession(session.getAttribute("sessionKey"), userId)) {

            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("views/NavigationView.jsp");
            requestDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect("login");

        }
    }
}
