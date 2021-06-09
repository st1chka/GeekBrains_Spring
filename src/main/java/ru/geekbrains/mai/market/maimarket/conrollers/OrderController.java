package ru.geekbrains.mai.market.maimarket.conrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.mai.market.maimarket.dtos.OrderDto;
import ru.geekbrains.mai.market.maimarket.models.Order;
import ru.geekbrains.mai.market.maimarket.models.User;
import ru.geekbrains.mai.market.maimarket.services.OrderService;
import ru.geekbrains.mai.market.maimarket.services.UserService;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @PostMapping
    public Order createNewProduct(Principal principal){
        User user = userService.findByUsername(principal.getName()).get();
        return orderService.createOrderForCurrentUser(user);
    }
    @GetMapping
    @Transactional
    public List<OrderDto> getAllOrdersForCurrentUser(Principal principal){
        User user = userService.findByUsername(principal.getName()).get();
        return orderService.findAllByUser(user).stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
