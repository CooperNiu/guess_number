package com.twschool.practice;

import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/score")
    public Map<String, String> getScore(@RequestParam String guess) {
        int score = 0;
        Map<String, String> map = new HashMap<>();
        RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        List<String> userAnswer = Arrays.asList(guess.split(" "));
        String result = guessNumberGame.guess(userAnswer);
//        System.out.print(guessNumberGame.getStatus());
        if (result.equals("4A0B")) {
            score += 3;
        } else {
            score -= 3;
        }
        map.put("score", Integer.toString(score));
        return map;
    }
}
