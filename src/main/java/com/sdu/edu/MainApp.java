package com.sdu.edu;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        // CRUD
        Session session = null;

        try {

           // Read



            session = factory.getCurrentSession();
            showProductsByPerson(2, session);

//            session.beginTransaction();
//            Person person = session.get(Person.class, 1);
//
//            System.out.println(person);
//            System.out.println(person.getProducts());
//
//            session.getTransaction().commit();


            //Read
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Person person = session.get(Person.class, 2);
//            session.getTransaction().commit();
//            System.out.println(person);


            //ADD
//            session = factory.getCurrentSession();
//            Person person = new Person();
//            person.setName("Ruslan");
//            session.beginTransaction();
//            session.save(person);
//            session.getTransaction().commit();
//
//
//            session = factory.getCurrentSession();
//            Product product = new Product();
//            product.setTitle("Asus Vivobook");
//            product.setPerson(person);
//            session.beginTransaction();
//            session.save(product);
//            session.getTransaction().commit();


        } finally {
            factory.close();
            session.close();
        }
    }


    static void showProductsByPerson(int id, Session session){
        session.beginTransaction();
        Person person = session.get(Person.class, id);
        System.out.println(person);
        System.out.println(person.getProducts());
        session.getTransaction().commit();
    }
}
