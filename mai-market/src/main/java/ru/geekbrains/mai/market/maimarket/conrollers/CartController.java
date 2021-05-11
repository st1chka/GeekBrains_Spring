package ru.geekbrains.mai.market.maimarket.conrollers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.mai.market.maimarket.dtos.CartDto;
import ru.geekbrains.mai.market.maimarket.dtos.ProductDto;
import ru.geekbrains.mai.market.maimarket.models.Product;
import ru.geekbrains.mai.market.maimarket.services.ProductService;
import ru.geekbrains.mai.market.maimarket.utils.Cart;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final Cart cart;
    private CartDto cartDto;
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> showCart() {
        cartDto = new CartDto(cart);
        return cartDto.showAll();
    }

    @GetMapping("/ping")
    public void ping(@RequestParam Long id) {
        log.info("ping: " + id);
    }

    @GetMapping("/add")
    public void addToCart(@RequestParam Long id) {
        Optional<Product> product = productService.findById(id);
        cart.addToCart(product.get());
    }
//
//    @GetMapping("/delete")
//    public void deleteOneProductById(@RequestParam Long id) {
//        cart.deleteById(id);
//    }
//
//    @GetMapping("/clear")
//    public void clearCart() {
//        cart.deleteAll();
//    }
//
//    @GetMapping("/sum")
//    public int getCartProductsSum() {
//        return cart.getProductsSum();
//    }
}