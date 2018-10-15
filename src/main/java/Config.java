import org.hibernate.SessionFactory;
        import org.hibernate.boot.Metadata;
        import org.hibernate.boot.MetadataSources;
        import org.hibernate.boot.registry.StandardServiceRegistry;
        import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Config {
    static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory != null)
            return sessionFactory;

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }
}
