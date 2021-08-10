package ru.geekbrains.stitch.spring;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public String[] brand = new String[]{"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};

    public List<Notebook> sort(List<Notebook> arr) {
        List<Notebook> left = new ArrayList<>();
        List<Notebook> middle = new ArrayList<>();
        List<Notebook> right = new ArrayList<>();

        if (arr.isEmpty()) {
            return arr;
        }
        Notebook base = arr.get(0);


        for (Notebook n : arr) {
            if (n.getPrice() > base.getPrice()) {
                right.add(n);
            }
            if (n.getPrice() == base.getPrice()) {

                if (n.getMemory() > base.getMemory()) {
                    right.add(n);
                }
                if (n.getMemory() < base.getMemory()) {
                    left.add(n);
                }
                if (n.getMemory() == base.getMemory()) {

                    if (sortAlphabet(n.getBrand(), brand) > sortAlphabet(base.getBrand(), brand)) {
                        right.add(n);
                    }
                    if (sortAlphabet(n.getBrand(), brand) < sortAlphabet(base.getBrand(), brand)) {
                        left.add(n);
                    }
                    if (sortAlphabet(n.getBrand(), brand) == sortAlphabet(base.getBrand(), brand)) {
                        middle.add(n);
                    }

                }
            } else if (n.getPrice() < base.getPrice()) {
                left.add(n);
            }
        }

        left = sort(left);
        right = sort(right);

        left.addAll(middle);
        left.addAll(right);

        return left;
    }

    public int sortAlphabet(String brand, String[] brands) {
        int count = 0;
        for (String s : brands) {
            if (!brand.equals(s)) {
                count++;
            } else {
                count++;
                break;
            }
        }
        return count;
    }
}
