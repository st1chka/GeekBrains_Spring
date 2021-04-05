package com.geekbrains.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("Utf-8");
        resp.getWriter().printf("<!DOCTYPE html>" + "<head>" + "<meta charset=utf-8>" + "</head>");
        resp.getWriter().printf("<body>");
        String arr[] = {"Яблоко", "Банан", "Апельсин", "Картошка", "Помидор", "Рукала", "Мандарин", "Молоко", "Хлеб", "Йогурт"};

        for (int i = 0; i < arr.length; i++) {
            resp.getWriter().printf("<h1>" + arr[i] + "</h1>");
        }


        resp.getWriter().printf("</body></html>");
//        logger.info("Log: GET");
//        resp.getWriter().printf("<html><body><h1>New GET request</h1></body></html>");
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