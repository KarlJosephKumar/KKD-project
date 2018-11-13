package model;

import hibernate.Config;
import hibernate.Login;
import hibernate.SessionLogin;
import hibernate.Student;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;


public class HibernateMethods {

    public static HibernateMethods hibernateMethods;

    public HibernateMethods(){
    }

    public static HibernateMethods getInstance(){
        if(hibernateMethods == null){
            hibernateMethods = new HibernateMethods();
        }
        return hibernateMethods;
    }

    public boolean loginCheck(String username, String password) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Login userPassword = session
                    .createNamedQuery("get_password_by_Login_username", Login.class)
                    .setParameter("username", username).getSingleResult();
            if (userPassword.getPassword().equals(password)) {
                return true;
            } else{
                return false;
            }

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Login checkId(String username) {


        try{
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            return session
                    .createNamedQuery("get_id_by_Login_username", Login.class)
                    .setParameter("username", username).getSingleResult();

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void addSession(Login user_id, String sessionKey) {

        try{
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();

            SessionLogin sessionLogin = new SessionLogin();
            hibernate.Session session1 = new hibernate.Session();
            session1.setSession_key(sessionKey);
            session.saveOrUpdate(session1);

            sessionLogin.setSessionId(session1);
            sessionLogin.setLoginId(user_id);
            session.saveOrUpdate(sessionLogin);

        } catch(Exception e) {
            e.printStackTrace();

        }

    }

    public void deleteSession(String sessionKey) {
        try{
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query q = session.createQuery("delete Session where session_key = :sessionKey");
            q.setParameter("sessionKey", sessionKey);
            q.executeUpdate();



        }catch(Exception e) {
            e.printStackTrace();
            return ;
        }
    }

    public List<Student> getAllStudents() {
        try{
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            List<Student> students = session
                    .createNamedQuery("get list of students")
                    .getResultList();

            return students;

        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
