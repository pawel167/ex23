package com.example.demo8;

import com.example.demo8.empl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    public static final SessionFactory sessionFactory;

    static {
        var config = new Configuration()
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/23")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "postgres")
                .addAnnotatedClass(empl.class);

        sessionFactory = config.buildSessionFactory();
    }
}