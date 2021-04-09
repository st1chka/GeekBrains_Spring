package ru.geekbrains.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component

public class Product {

    private final long id;
    private final String title;
    private final int price;

    public Product(long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public long getId() {
        return id;
    }

}
