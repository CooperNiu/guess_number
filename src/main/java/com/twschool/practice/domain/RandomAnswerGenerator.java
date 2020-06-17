package com.twschool.practice.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomAnswerGenerator {
    public Answer generateAnswer() {
        List<Integer> numberSource = IntStream.range(1, 9).boxed().collect(Collectors.toList());
        Collections.shuffle(numberSource);
        List<String> numbers = numberSource.stream().limit(4).map(String::valueOf).collect(Collectors.toList());
        return new Answer(numbers);
    }
}
