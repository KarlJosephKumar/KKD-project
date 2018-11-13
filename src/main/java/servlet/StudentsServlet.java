package servlet;

import hibernate.Student;
import model.HibernateMethods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HibernateMethods hibernateMethods = HibernateMethods.getInstance();

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


    }
}
