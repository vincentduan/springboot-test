package com.vincent.service.impl;

import com.vincent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FactoryForStrategy {
    @Autowired
    Map<String, UserService> strategys = new ConcurrentHashMap<>(3);

    public UserService getStrategy(String component) throws Exception{
        UserService strategy = strategys.get(component);
        if(strategy == null) {
            throw new RuntimeException("no strategy defined");
        }
        return strategy;
    }

}
