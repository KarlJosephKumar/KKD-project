package model;

import hibernate.Config;
import hibernate.Login;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class HibernateMethods {

    public boolean LoginCheck(String username, String password) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Login userPassword = session
                    .createNamedQuery("get_password_by_Login_username", Login.class)
                    .setParameter("username", username).getSingleResult();
            if (userPassword.equals(password)) {
                return true;
            } else{
                return false;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
