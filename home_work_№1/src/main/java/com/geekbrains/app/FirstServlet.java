package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class FirstServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);
    protected static int id;
    protected static int cost;
    protected static String title;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("Utf-8");
        resp.getWriter().printf("<!DOCTYPE html>" + "<head>" + "<meta charset=utf-8>" + "</head>");
        resp.getWriter().printf("<body>");

        Product basket1 = new Product(1, "Яблоко", 30);
        Product basket2 = new Product(2, "Банан", 25);
        Product basket3 = new Product(3, "Апельсин", 15);
        Product basket4 = new Product(4, "Картошка", 6);
        Product basket5 = new Product(5, "Помидор", 10);
        Product basket6 = new Product(6, "Руккола", 14);
        Product basket7 = new Product(7, "Мандарин", 30);
        Product basket8 = new Product(8, "Молоко", 30);
        Product basket9 = new Product(9, "Хлеб", 80);
        Product basket10 = new Product(10, "Петрушка", 30);


        Basket(resp, basket1, basket2, basket3, basket4, basket5);
        Basket(resp, basket6, basket7, basket8, basket9, basket10);


    }

    private void Basket(HttpServletResponse resp, Product basket6, Product basket7, Product basket8, Product basket9, Product basket10) throws IOException {
        resp.getWriter().printf("<h1>" +  basket6 .id + ": " +  basket6 .title +  basket6 .cost + " руб" + "</h1>");
        resp.getWriter().printf("<h1>" +  basket7 .id + ": " +  basket7 .title +  basket7 .cost + " руб" + "</h1>");
        resp.getWriter().printf("<h1>" +  basket8 .id + ": " +  basket8 .title +  basket8 .cost + " руб" + "</h1>");
        resp.getWriter().printf("<h1>" +  basket9 .id + ": " +  basket9 .title +  basket9 .cost + " руб" + "</h1>");
        resp.getWriter().printf("<h1>" +  basket10.id + ": " +  basket10.title +  basket10.cost + " руб" + "</h1>");
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.debug("Log: POST");
//        resp.getWriter().printf("<html><body><h1>New POST request</h1></body></html>");
//    }

    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}