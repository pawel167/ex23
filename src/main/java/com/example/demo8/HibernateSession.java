package com.example.demo8;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {

  private static Configuration conf;
  public static SessionFactory sessionFactory;

    static {
        conf = new Configuration()
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/exam9")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "postgres")
                .addAnnotatedClass(empl.class);

        sessionFactory = conf.buildSessionFactory();
    }

}
