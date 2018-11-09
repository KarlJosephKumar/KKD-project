package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            String sessionKey = (String) session.getAttribute("sessionKey");
            if (sessionKey != null && sessionKey.equals("random-string")) {
                req.setAttribute("names", asList("Vitya", "Barack"));
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user.jsp");
                requestDispatcher.forward(req, resp);
                return;
            }
        }
        PrintWriter writer = resp.getWriter();
        writer.println("You can't view this page. Please go to login - http://localhost:8080/login");

    }
}
