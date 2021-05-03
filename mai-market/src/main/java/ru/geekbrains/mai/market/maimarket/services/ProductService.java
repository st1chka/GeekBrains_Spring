package ru.geekbrains.mai.market.maimarket.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import ru.geekbrains.mai.market.maimarket.models.Product;
import ru.geekbrains.mai.market.maimarket.repositories.ProductRepository;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }


    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id){
      productRepository.deleteById(id);
    }
    public  Product put(Product product){
        return productRepository.save(product);
    }
}
