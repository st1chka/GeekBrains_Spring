package ru.geekbrains.mai.market.maimarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.mai.market.maimarket.models.Order;
import ru.geekbrains.mai.market.maimarket.models.User;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUser(User user);

}
