package ru.geekbrains.stitch.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Main {

    private static final Random random = new Random();


    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();
        List<Notebook> arr = new ArrayList<>();

        for (int i = 0; i < 5000; i++) {
            arr.add(new Notebook(getPrice(), getMemory(), getName()));
        }
        System.out.println(quickSort.sort(arr));
        System.out.println(arr.size());

//        quickSort.sortAlphabet(arr);

    }


    public static String getName() {
        int min = 0;
        int max = 4;
        int diff = max - min;

        Random randomName = new Random();

        int IndexName = randomName.nextInt(diff + 1);

        String[] name = new String[5];

        name[0] = "Lenovo";
        name[1] = "Asos";
        name[2] = "MacNote";
        name[3] = "Eser";
        name[4] = "Xamiou";


        return name[IndexName];
    }


    private static int getMemory() {
        int minMemory = 4;
        int memory = 0;
        int steps = 4;
        int maxMemory = 12;
        return random(steps, minMemory, memory, maxMemory);
    }


    private static int getPrice() {
        int minPrice = 500;
        int steps = 100;
        int price = 0;
        int maxPrice = 1000;
        return random(steps, minPrice, price, maxPrice);
    }


    private static int random(int steps, int min, int randomValue, int max) {
        int stepsFormula = (random.nextInt(max - min) + 1);

        if (min == 500 && max == 1000) {

            randomValue = getRandomPrice(steps, min, stepsFormula);

        } else if (min == 4 && max == 12) {

            randomValue = getRandomMemory(steps, min, stepsFormula);
        }
        return randomValue;
    }

    private static int getRandomMemory(int steps, int min, int stepsFormula) {
        int randomValue;
        stepsFormula = stepsFormula + min;
        randomValue = stepsFormula - stepsFormula % steps;
        return randomValue;
    }

    private static int getRandomPrice(int steps, int min, int stepsFormula) {
        int randomValue;
        stepsFormula = stepsFormula + min;
        randomValue = stepsFormula - stepsFormula % steps;
        return randomValue;
    }
}
