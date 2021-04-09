package ru.geekbrains.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Component
public class ProductRepository {


    private List<Product> products;


    @PostConstruct
    public void init (){
        products = new ArrayList<>(Arrays.asList(
                new Product(1L,"Стол", 2000),
                new Product(2L,"Стул", 1500),
                new Product(3L,"Кровать", 5000),
                new Product(4L,"Табурет", 100),
                new Product(5L,"Кресло", 25000),
                new Product(555L,"Кресло", 25000)
        ));
    }

    public Product getProductId(long id){
        Product list = null;
        for (Product product : products) {
            if (product.getId() == id){
                list = product;
            }
        }
        return list;
    }

}
