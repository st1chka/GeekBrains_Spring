package com.geekbrains.app;

public class Product {
    int id;
    String title;
    int cost;

    Product(int id, String title, int cost){
         this.id = id;
         this.title = title;
         this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
