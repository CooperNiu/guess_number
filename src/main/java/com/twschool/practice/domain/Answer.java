package com.twschool.practice.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Answer {
    
    private List<String> answerNumbers;

    public Answer(List<String> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public String check(List<String> userAnswerNumbers) {
        int valueAndPositionCorrectCount = 0;
        int valueIncorrectButPositionCorrectCount = 0;

        for (int index = 0; index < userAnswerNumbers.size(); index++) {
            if (answerNumbers.get(index).equals(userAnswerNumbers.get(index))) {
                valueAndPositionCorrectCount ++;
            } else if (answerNumbers.contains(userAnswerNumbers.get(index))) {
                valueIncorrectButPositionCorrectCount ++;
            }
        }
        return valueAndPositionCorrectCount + "A" + valueIncorrectButPositionCorrectCount + "B";
    }

    public boolean isValidFormat() {
        Set<String> answerNumberSet = this.answerNumbers.stream()
                .filter(answerNumber -> answerNumber.matches("\\d"))
                .collect(Collectors.toSet());
        boolean isValidFormat = answerNumberSet.size() == 4;
        return isValidFormat;
    }
}
