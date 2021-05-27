package ru.geekbrains.mai.market.maimarket.conrollers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.mai.market.maimarket.AOP.AppAround;

import java.util.HashMap;
import java.util.Iterator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/statistic")
public class AppController {
    private final AppAround appAround;

//    , appAround.getOrderServiceTotalDuration(), appAround.getUserServiceTotalDuration();

    @GetMapping()
    public HashMap<String, Long> chekStatisticProduct() {
        HashMap<String, Long> statistic = new HashMap();
        statistic.put("Product service", appAround.getProductServiceTotalDuration());
        statistic.put("Order service", appAround.getOrderServiceTotalDuration());
        statistic.put("User service", appAround.getUserServiceTotalDuration());

        return statistic;

    }

//    @GetMapping("/{id}")
//    public Category getOneCategoryById(@PathVariable Long id) {
//        return categoryService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category doesn't exists: " + id));
//    }


}
