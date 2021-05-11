package ru.geekbrains.mai.market.maimarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.mai.market.maimarket.models.Category;
import ru.geekbrains.mai.market.maimarket.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByTitle(String title);

}
