package ru.geekbrains.spring.one.repositories;



import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.one.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    Optional<Product> findOneByTitle(String title);
//    List<Product> findAllByPriceLessThan(int price);
//    List<Product> findAllByPriceBefore(int max);
//    List<Product> findAllByIdLessThanAndPriceGreaterThan(Long maxId, int minPrice);
//    @Query("select p from Product p where p.id = :id")
//    List<Product> hqlFindById(Long id);
    Page<Product> findAllByPriceBetween(int min, int max, Pageable pageable);
//    Page<Product> findAllByPriceBetween(int min, int max,Pageable pageable);
//    Page<Product> findAllByPriceBetween(int min, int max,
}
