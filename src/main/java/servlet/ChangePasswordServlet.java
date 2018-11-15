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

public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/ChangePassword.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateMethods hibernateMethods = HibernateMethods.getInstance();
        HttpSession session = req.getSession();
        Login userId = (Login) session.getAttribute("userId");
        PrintWriter out = resp.getWriter();

        String password = req.getParameter("new_password");
        String password2= req.getParameter("new_password_again");

        if(hibernateMethods.checkForSession(session.getAttribute("sessionKey"), userId)){
            if(password.equals(password2)){
                hibernateMethods.changePassword(userId, password);
                resp.sendRedirect("nav");
            } else{
                out.println("<html><head></head><body>");
                out.println("<b>The passwords dont match</b>");
                out.println("</BODY></HTML>");
            }
        } else {
            resp.sendRedirect("login");
        }

    }
}
