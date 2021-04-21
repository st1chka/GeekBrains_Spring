package ru.geekbrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductDao {

    private final SessionFactory factory;

    public ProductDao(SessionFactory factory) {
        this.factory = factory;
    }


    public SessionFactory getFactory() {
        return factory;
    }


    public void showManyItem(){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List productList = session.createQuery("from Product").getResultList();
            System.out.println(productList + "\n");
        }
    }

    public void createExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product dragons = new Product("Dragons", 100);
            session.save(dragons);
            System.out.println(dragons);
            session.getTransaction().commit();
        }
    }

    public  void deleteExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product simpleItem = session.get(Product.class, 1L);
            session.delete(simpleItem);
            session.getTransaction().commit();
        }
    }

    public void readAndPrintExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product simpleProduct = session.get(Product.class, 3L);
            System.out.println(simpleProduct);
            session.getTransaction().commit();
        }

    }


    public void updateExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product simpleProduct = session.get(Product.class, 6L);
            simpleProduct.setPrice(200);
            session.getTransaction().commit();
        }
    }



}

