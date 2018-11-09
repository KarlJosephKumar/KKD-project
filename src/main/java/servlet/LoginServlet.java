package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/newUser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (password.equals("1234")) {
            HttpSession session = req.getSession();
            session.setAttribute("sessionKey", "random-string");
            PrintWriter writer = resp.getWriter();
            writer.println("Welcome Barack!");
            return;
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/newUser.jsp");
        requestDispatcher.forward(req, resp);
    }


}
