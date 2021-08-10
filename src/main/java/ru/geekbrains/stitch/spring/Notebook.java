package ru.geekbrains.stitch.spring;

public class Notebook {
    private int price;
    private int memory;
    private String brand;



    public Notebook(int price, int memory, String brand) {
        this.price = price;
        this.memory = memory;
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "ru.Notebook{" +
                "Цена=" + price +
                ", Память=" + memory +
                ", Бренд=" + brand +
                '}';
    }
}
