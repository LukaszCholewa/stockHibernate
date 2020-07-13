package pl.camp.it.session;


import org.hibernate.cfg.Configuration;

public class SessionFactory {
    public static org.hibernate.SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();
}
