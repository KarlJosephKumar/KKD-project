import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.security.acl.Group;


public class Main {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

//        Room room = session
//                .createNamedQuery("get_all_by_id", Room.class)
//                .setParameter("id", 1).getSingleResult();

            String hql = "select pr from Room pr";

//            GroupClass groupClass = session
//                    .createNamedQuery("get_all_by_Class_id", GroupClass.class)
//                    .setParameter("id", 1).getSingleResult();

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
