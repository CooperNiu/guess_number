package com.twschool.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "world");
        return map;
    }
}
