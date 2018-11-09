package servlet;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HibernateMethods hibernateMethods = HibernateMethods.getInstance();

        if (hibernateMethods.LoginCheck(username, password)) {

            int userId = hibernateMethods.checkId(username);

            HttpSession session = req.getSession();
            String sessionKey = UUID.randomUUID().toString();
            session.setAttribute("sessionKey", sessionKey);


        }
        }




//        if (password.equals("1234")) {
//            HttpSession session = req.getSession();
//            session.setAttribute("sessionKey", "random-string");
//            PrintWriter writer = resp.getWriter();
//            writer.println("Welcome Barack!");
//            return;
//        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/newUser.jsp");
        requestDispatcher.forward(req, resp);
}
