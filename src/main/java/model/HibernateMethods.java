package model;

import hibernate.Config;
import hibernate.Login;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


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

    public boolean LoginCheck(String username, String password) {
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

            Login userId = session
                    .createNamedQuery("get_id_by_Login_username", Login.class)
                    .setParameter("username", username).getSingleResult();



            return userId;

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void addSession(String key, Login user_id) {

        try{
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            hibernate.Session session1 = new hibernate.Session();
            session1.setSession_key(key);
//            session1.setUser_id(user_id);

            session.save(session1);


            session.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            return ;
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





}
