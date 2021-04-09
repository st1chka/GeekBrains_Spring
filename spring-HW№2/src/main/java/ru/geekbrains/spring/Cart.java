package ru.geekbrains.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private final List<Product> cart;
    private final ProductRepository productRepository;

    public Cart(List<Product> cart, ProductRepository productRepository) {
        this.cart = cart;
        this.productRepository = productRepository;
    }

    public void addCart(long id) {
        cart.add(productRepository.getProductId(id));
    }
    public void deleteCart(long id) {
        cart.remove(productRepository.getProductId(id));
    }

    public void searchCart(){
        for (Product product : cart) {
            System.out.println(product);
        }
    }


}
