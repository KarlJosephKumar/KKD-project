import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

//        Course room = session
//                .createNamedQuery("get_all_by_Course_id", Course.class)
//                .setParameter("id", 1).getSingleResult();
//            List<Course> courses = session
//                    .createNamedQuery("get_all_by_Course_id", Course.class)
//                    .getResultList();

            String hql = "select pr from Room pr";


            Student student = session
                    .createNamedQuery("get_all_by_Student_id", Student.class)
                    .setParameter("id", 1).getSingleResult();

            //Query student = session.createQuery("select Student.name from Student s where s.id = 1 ").getSingleResult();

//            List <Student> student = session
//                .createNamedQuery("get_all_by_Student_id", Student.class)
//                    .getResultList();

            //session.persist(student);
            System.out.println(student);


            transaction.commit();
            session.close();
            //session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
