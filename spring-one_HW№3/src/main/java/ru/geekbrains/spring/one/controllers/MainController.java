package ru.geekbrains.spring.one.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    // [http://localhost:8189/app]/alpha
    @GetMapping("/alpha")
    @ResponseBody
    public String getAlpha() {
        return "Get Alpha";
    }

    // [http://localhost:8189/app]/alpha
    @PostMapping("/alpha")
    @ResponseBody
    public String postAlpha() {
        return "Post Alpha";
    }

    // [http://localhost:8189/app]/betta
    @GetMapping("/betta")
    @ResponseBody
    public String getBetta() {
        return "Get Betta";
    }

    // [http://localhost:8189/app]/add?my_VaLuE_11=10&val2=20
    @GetMapping("/add")
    @ResponseBody
    public Integer getAddOperation(@RequestParam(name = "my_VaLuE_11", required = false) Integer val1, @RequestParam(defaultValue = "0") Integer val2) {
        return val1 + val2;
    }

    // [http://localhost:8189/app]/users/1/info
    @GetMapping("/users/{id}/info")
    @ResponseBody
    public String getUserInfo(@PathVariable(name = "id") Long id) {
        return "User info: " + id;
    }
}
