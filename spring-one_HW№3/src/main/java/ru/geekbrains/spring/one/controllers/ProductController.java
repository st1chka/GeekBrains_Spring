package ru.geekbrains.spring.one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // [http://localhost:8189/app]/product/all
    @GetMapping("/all")
    public String showAllProductsPage(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }


    // [http://localhost:8189/app]/product/creator
    @GetMapping("/create")
    public String showCreator() {
        return "create_product_form";
    }

    // [http://localhost:8189/app]/students/create?id=10&name=Nicolas&score=95
    @PostMapping("/create")
    public String createNewProduct(@RequestParam Long id, @RequestParam String name, @RequestParam int score) {
        Product product = new Product(id, name, score);
        productService.save(product);
        return "redirect:/product/all";
    }
}
