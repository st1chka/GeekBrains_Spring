package ru.geekbrains.mai.market.maimarket.conrollers;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.mai.market.maimarket.error_hendling.ResourceNotFoundException;
import ru.geekbrains.mai.market.maimarket.models.Category;
import ru.geekbrains.mai.market.maimarket.models.Product;
import ru.geekbrains.mai.market.maimarket.services.CategoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getOneCategoryById(@PathVariable Long id){
        return categoryService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Категория не найдена: "+id));
    }
}
