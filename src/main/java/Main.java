
import hibernate.Config;
import hibernate.Payments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

//        hibernate.Course room = session
//                .createNamedQuery("get_all_by_Course_id", hibernate.Course.class)
//                .setParameter("id", 1).getSingleResult();
//            List<hibernate.Course> courses = session
//                    .createNamedQuery("get_all_by_Course_id", hibernate.Course.class)
//                    .getResultList();

            String hql = "select pr from hibernate.Room pr";


            Payments payments = session
                    .createNamedQuery("get_all_by_Payments_id", Payments.class)
                    .setParameter("id", 1).getSingleResult();

            //Query student = session.createQuery("select hibernate.Student.name from hibernate.Student s where s.id = 1 ").getSingleResult();

//            List <hibernate.Student> student = session
//                .createNamedQuery("get_all_by_Student_id", hibernate.Student.class)
//                    .getResultList();

            //session.persist(student);
            System.out.println(payments);


            transaction.commit();
            session.close();
            //session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
