package ru.geekbrains.mai.market.maimarket.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.geekbrains.mai.market.maimarket.models.Product;
import ru.geekbrains.mai.market.maimarket.repositories.ProductRepository;
import ru.geekbrains.mai.market.maimarket.services.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
@Data
public class Cart {
    private List<Product> items;
    private ProductService productService;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public void deleteById(Long id) {
        for (Product item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                break;
            }
        }
    }

    public void deleteAll() {
        items.clear();
    }

    public void addToCart(Product product) {
        items.add(product);
    }

    public List<Product> showAll() {
        return items;
    }

    public int getProductsSum() {
        int sum = 0;
        for (Product item : items) {
            sum += item.getPrice();
        }
        return sum;
    }
}