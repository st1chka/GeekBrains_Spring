package ru.geekbrains.mai.market.maimarket.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.mai.market.maimarket.models.Product;
import ru.geekbrains.mai.market.maimarket.utils.Cart;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CartDto {
    private List<ProductDto> productDtoList;

    public CartDto(Cart cart) {
        List<ProductDto> list = new ArrayList<>();
        for (Product product : cart.getItems()) {
            ProductDto productDto = new ProductDto(product);
            list.add(productDto);
        }
        this.productDtoList = list;
    }

    public List<ProductDto> showAll() {
        return productDtoList;
    }

    public void addToCart(ProductDto productDto) {
        productDtoList.add(productDto);
    }
}
