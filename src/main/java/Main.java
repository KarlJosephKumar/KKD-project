import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Config.getSessionFactory();
        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Room room = session
                .createNamedQuery("get_all_by_id", Room.class)
                .setParameter("id", 1)
                .getSingleResult();

        System.out.println(room);



        transaction.commit();
        session.close();
    }

}
