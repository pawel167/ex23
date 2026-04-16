package com.example.demo8;

import java.util.List;

public class DBService {

    public List<empl> findAll(){
        try(var session =  HibernateSession.sessionFactory.openSession()){
            return session.createQuery("FROM empl", empl.class).list();
        }
    }
}
