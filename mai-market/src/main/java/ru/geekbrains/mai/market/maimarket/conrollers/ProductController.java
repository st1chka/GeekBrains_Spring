package ru.geekbrains.mai.market.maimarket.conrollers;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.mai.market.maimarket.models.Product;
import ru.geekbrains.mai.market.maimarket.services.ProductService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
         productService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Product getOneProductById(@PathVariable Long id){
        return productService.findById(id).get();
    }

    @PutMapping()
    public Product updateProduct(@RequestBody Product product){
        return productService.put(product);
    }


    @PostMapping
    public Product createNewProduct(@RequestBody Product product){
        return productService.save(product);
    }

}
