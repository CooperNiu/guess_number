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

    @GetMapping("/tryOnceScore")
    public Map<String, String> getScore(@RequestParam String result) {
        int score = 0;
        Map<String, String> map = new HashMap<>();
//        System.out.print(guessNumberGame.getStatus());
        if (result.equals("4A0B")) {
            score += 3;
        } else {
            score -= 3;
        }
        map.put("score", Integer.toString(score));
        return map;
    }

    @GetMapping("/trySeveralTimesScore")
    public Map<String, String> getSeveralTimesScore(@RequestParam String[] result) {
        int score = 0;
        int guessRight = 0;
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < result.length; i++) {
            if (result[i].equals("4A0B") && (guessRight == 0 || guessRight == 1)) {
                guessRight++;
                score += 3;
            } else if (result[i].equals("4A0B") && guessRight == 4) {
                guessRight++;
                score += 6;
            } else if (result[i].equals("4A0B") && (guessRight == 5 || guessRight == 2)) {
                guessRight++;
                score += 5;
            } else {
                guessRight = 0;
                score -= 3;
            }
        }
        map.put("score",Integer.toString(score));
        return map;
}
}
