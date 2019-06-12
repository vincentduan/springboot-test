package com.vincent.controller;

import com.vincent.service.UserService;
import com.vincent.service.impl.FactoryForStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    @Qualifier("female")
    UserService femaleService;

    @Autowired
    FactoryForStrategy factoryForStrategy;

    @GetMapping("/gender")
    public String getGender(){
        femaleService.getGender("nv");
        return "success";
    }

    @GetMapping("/gender2/{gender}/{name}")
    public String getGender2(@PathVariable String gender, @PathVariable String name) {
        try {
            UserService strategy = factoryForStrategy.getStrategy(gender);
            String gender1 = strategy.getGender(name);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }

}
