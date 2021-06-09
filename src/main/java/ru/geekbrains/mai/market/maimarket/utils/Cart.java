package ru.geekbrains.mai.market.maimarket.utils;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.geekbrains.mai.market.maimarket.models.OrderItem;
import ru.geekbrains.mai.market.maimarket.models.Product;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


@Component
@Data
@RequiredArgsConstructor
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)

public class Cart implements Serializable {

    private List<OrderItem> items;
    private BigDecimal sum;
    private Product product;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public void addToCart(Product product, Long id) {
        for (OrderItem orderItem : items) {
            if (orderItem.getProduct().getId().equals(product.getId())) {
                orderItem.incrementQuantity();
                recalculate();
                return;
            }
        }
       items.add(new OrderItem(product));
        recalculate();

    }

    public void clear() {
        items.clear();
        recalculate();
    }

    private void recalculate() {
        sum = BigDecimal.ZERO;
        for (OrderItem oi : items) {
            sum = sum.add(oi.getPrice());
        }
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Product getProduct(Product product) {
        return this.product;
    }
}
