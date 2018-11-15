package model;

import hibernate.Config;
import hibernate.Login;
import hibernate.SessionLogin;
import hibernate.Student;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;


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

    public boolean checkIfUserExist(String username){
        try{
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Login user = session
                    .createNamedQuery("check_if_username_exist", Login.class)
                    .setParameter("username", username).getSingleResult();
            if(user.getUsername().equals(username)){
                return true;
            } else{
                return false;
            }

        }catch (NoResultException e){
            //Leave this empty, logic works.
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
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
            Transaction transaction = session.beginTransaction();

            SessionLogin sessionLogin = new SessionLogin();
            hibernate.Session session1 = new hibernate.Session();
            session1.setSession_key(sessionKey);
            session.saveOrUpdate(session1);

            sessionLogin.setSessionId(session1);
            sessionLogin.setLoginId(user_id);
            session.saveOrUpdate(sessionLogin);

            session.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();

        }

    }

    public boolean checkForSession(Object sessionKey, Login userId) {
        try{
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            SessionLogin sessionLogin = session
                    .createNamedQuery("get_session_login_by_sessionId", SessionLogin.class)
                    .setParameter("sessionKey", String.valueOf(sessionKey) ).getSingleResult();
            Login user = sessionLogin.getLoginId();
            if (user.getId() == userId.getId()) {
                return true;
            }
            return false;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void deleteSession(Object sessionKey) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            SessionLogin sessionLogin = session
                    .createNamedQuery("delete session by sessionKey", SessionLogin.class)
                    .setParameter("sessionKey", String.valueOf(sessionKey)).getSingleResult();
            session.saveOrUpdate(sessionLogin);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addAccount(String username, String password){
        SessionFactory sessionFactory = Config.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Login login = new Login();
            login.setUsername(username);
            login.setPassword(password);
            session.saveOrUpdate(login);
            session.getTransaction().commit();

    }
    public void changePassword(Login userId, String password){
        SessionFactory sessionFactory = Config.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query changePasswordQuery = session.createQuery("update Login l set l.password = :password where id = :id");
                changePasswordQuery.setParameter("password", password);
                changePasswordQuery.setParameter("id", userId.getId());
                changePasswordQuery.executeUpdate();

        session.getTransaction().commit();

    }

    public void addStudent(String name, String surname, Date birthday, String nationality, String username){
        SessionFactory sessionFactory = Config.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Login loginId = session
                .createNamedQuery("get_id_by_Login_username", Login.class)
                .setParameter("username", username).getSingleResult();

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setDate_of_birth(birthday);
        student.setNationality(nationality);
        student.setLogin_id(loginId);
        session.saveOrUpdate(student);
        session.getTransaction().commit();
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
