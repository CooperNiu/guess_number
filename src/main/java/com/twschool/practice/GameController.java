package com.twschool.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {
    @GetMapping("/game")
    public Map<String, String> guess(@RequestParam String guess) {
        Map<String, String> map = new HashMap<>();
        map.put("input", guess);
        map.put("result", "4A0B");
        return map;
    }
}
