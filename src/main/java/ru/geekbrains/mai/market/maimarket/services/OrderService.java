package ru.geekbrains.mai.market.maimarket.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;
import ru.geekbrains.mai.market.maimarket.models.Order;
import ru.geekbrains.mai.market.maimarket.models.OrderItem;
import ru.geekbrains.mai.market.maimarket.models.User;
import ru.geekbrains.mai.market.maimarket.repositories.OrderRepository;
import ru.geekbrains.mai.market.maimarket.utils.Cart;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final Cart cart;

    public List<Order> findAllByUser(User user){
        return orderRepository.findAllByUser(user);
    }

    public Order createOrderForCurrentUser(User user){
        Order order = new Order();
        order.setUser(user);
        order.setPrice(cart.getSum());
        order.setItems(cart.getItems());
        for(OrderItem oi : cart.getItems()){
            oi.setOrder(order);
        }
        order = orderRepository.save(order);
        cart.clear();
        return order;
    }

}
