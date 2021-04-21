package ru.geekbrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;



public class MainApp {
    private static SessionFactory factory;
    private static ProductDao productDao;

    public static void init() {
        factory = new Configuration()
                .addAnnotatedClass(Product.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        try {
            init();
            prepareData();
            ProductDao productDao = new ProductDao(factory);

//            productDao.createExample();
//            productDao.readAndPrintExample();
//            productDao.updateExample();
//            productDao.deleteExample();
            productDao.showManyItem();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void prepareData() {
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public static void shutdown() {
        factory.close();
    }
}
