package ru.geekbrains.spring.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.repositories.ProductRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> findAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page,size));
    }
    public Page<Product> findAllPriceLow(int page, int size) {
        return productRepository.findAll(PageRequest.of(page,size, Sort.Direction.DESC, "price"));
    }

    public Page<Product> findAllByPriceBetween(int min, int max, int page, int size){
        return productRepository.findAllByPriceBetween(min,max, PageRequest.of(page,size));
    }
//    public Page<Product> findAllByPriceBetween(int min, int max, int page, int size){
//        return productRepository.findAllByPriceBetween(min,max, (Pageable) PageRequest.of(page,size));
//    }


    public Optional<Product> findOneById(Long id) {
        return productRepository.findById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void incrementPriceById(Long id, int amount) {
        Product p = productRepository.findById(id).get();
        p.incrementPrice(amount);
    }
    @Transactional
    public void decrementPriceById(Long id, int amount) {
        Product p = productRepository.findById(id).get();
        p.incrementPrice(amount);
    }
}
