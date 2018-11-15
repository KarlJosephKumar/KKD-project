package servlet;

import hibernate.Login;
import hibernate.Student;
import model.HibernateMethods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HibernateMethods hibernateMethods = HibernateMethods.getInstance();

        HttpSession session = req.getSession();
        Login userId = (Login) session.getAttribute("userId");

        if (!session.getAttribute("sessionKey").equals(null) && hibernateMethods.checkForSession(session.getAttribute("sessionKey"), userId)) {

            List<Student> studentList = hibernateMethods.getAllStudents();
            List<String> fullname = new ArrayList<>();
            List<Date> dob = new ArrayList<>();
            List<String> nationality = new ArrayList<>();

            //Get students full name
            for (Student student : studentList) {
                fullname.add(student.getSurname() + " " + student.getName());
                dob.add(student.getDate_of_birth());
                nationality.add(student.getNationality());
            }

            req.setAttribute("studentList", studentList);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/StudentsView.jsp");
            requestDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect("login");
//            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("views/Login.jsp");
//            requestDispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateMethods hibernateMethods = HibernateMethods.getInstance();

        HttpSession session = req.getSession();
        Login userId = (Login) session.getAttribute("userId");

        hibernateMethods.deleteSession(session.getAttribute("sessionKey"));


    }
}
