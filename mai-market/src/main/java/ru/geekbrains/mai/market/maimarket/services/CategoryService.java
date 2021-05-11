package ru.geekbrains.mai.market.maimarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.mai.market.maimarket.models.Category;
import ru.geekbrains.mai.market.maimarket.models.Product;
import ru.geekbrains.mai.market.maimarket.repositories.CategoryRepository;
import ru.geekbrains.mai.market.maimarket.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

}
