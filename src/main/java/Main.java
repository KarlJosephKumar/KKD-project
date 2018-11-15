
import hibernate.*;
import model.HibernateMethods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            String username = "karl";
            Login userId = session
                    .createNamedQuery("get_id_by_Login_username", Login.class)
                    .setParameter("username", username).getSingleResult();

//
//            hibernateMethods.addSession(userId);
//
//            session.saveOrUpdate(session1);
//            session.getTransaction().commit();
//            session.persist(userId);
//            hibernate.Session session1 = session
//                    .createNamedQuery("get_session_by_key", hibernate.Session.class)
//                    .setParameter("session_key", "f41d4ea2-5aa9-4e2c-8dab-4b999209d3eb").getSingleResult();
//                    .createNamedQuery("get_session_by_key", hibernate.Session.class)
//                    .setParameter("session_key","57c5eba9-f31b-483e-8d15-61ec302bdc3a");

//            List<Student> students = session
//                    .createNamedQuery("get list of students")
//                    .getResultList();

            SessionLogin sessionLogin1 = session
                    .createNamedQuery("get_session_login_by_sessionId", SessionLogin.class)
                    .setParameter("sessionKey", "69e15335-db8e-4ece-8a86-888eb6a8d722").getSingleResult();

            System.out.println(sessionLogin1);
//            for (Student pupil : students) {
//                System.out.println(pupil);
//            }
//            transaction.commit();
            session.close();
            //session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

//Query student = session.createQuery("select hibernate.Student.name from hibernate.Student s where s.id = 1 ").getSingleResult();

//            List <hibernate.Student> student = session
//                .createNamedQuery("get_all_by_Student_id", hibernate.Student.class)
//                    .getResultList();

//session.persist(student);

//        hibernate.Course room = session
//                .createNamedQuery("get_all_by_Course_id", hibernate.Course.class)
//                .setParameter("id", 1).getSingleResult();
//            List<hibernate.Course> courses = session
//                    .createNamedQuery("get_all_by_Course_id", hibernate.Course.class)
//                    .getResultList();

//    String hql = "select pr from hibernate.Room pr";
