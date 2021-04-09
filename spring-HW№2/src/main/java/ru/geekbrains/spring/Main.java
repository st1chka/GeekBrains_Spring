package ru.geekbrains.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean("productRepository",ProductRepository.class);
        Cart cart = context.getBean("cart",Cart.class);
        Cart cart2 = context.getBean("cart",Cart.class);

        // Просмотр продукта по id
        System.out.println(productRepository.getProductId(5));
        System.out.println();

        // Добавляем в корзину
        cart.addCart(1L);
        cart.addCart(2L);
        cart.addCart(3L);
        cart.addCart(555L);


        //Проверка корзины
        cart.searchCart();
        System.out.println();

        
        //Проверка второй корзины
        cart2.searchCart();
        System.out.println();



        //Убираем лишнее
        cart.deleteCart(2L);
        cart.deleteCart(1L);

        //Проверка корзины
        cart.searchCart();

        context.close();
    }
}
