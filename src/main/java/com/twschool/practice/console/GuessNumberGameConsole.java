package com.twschool.practice.console;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;

import java.util.Arrays;
import java.util.List;

public class GuessNumberGameConsole {
    
    private GuessNumberGame guessNumberGame;
    private ConsoleInputReader consoleInputReader;
    private ConsoleOutputWriter consoleOutputWriter;

    public GuessNumberGameConsole(RandomAnswerGenerator randomAnswerGenerator, ConsoleInputReader consoleInputReader, ConsoleOutputWriter consoleOutputWriter) {
        guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        this.consoleInputReader = consoleInputReader;
        this.consoleOutputWriter = consoleOutputWriter;
    }

    public String guess(String userAnswerString) {
        List<String> userAnswerNumbers = Arrays.asList(userAnswerString.split(" "));
        Answer userAnswer = new Answer(userAnswerNumbers);
        if (!userAnswer.isValidFormat()) {
            return "Wrong Input，Input again";
        }
        return guessNumberGame.guess(userAnswerNumbers);
    }

    public void play() {
        while (guessNumberGame.getStatus() == GameStatus.CONTINUED) {
            consoleOutputWriter.output("input answer: ");
            String userAnswerString = consoleInputReader.getInput();
            String result = guess(userAnswerString);
            consoleOutputWriter.output("result: " + result);
        }

        if (guessNumberGame.getStatus() == GameStatus.SUCCEED) {
            consoleOutputWriter.output("SUCCEED");
        }
        if (guessNumberGame.getStatus() == GameStatus.FAILED) {
            consoleOutputWriter.output("FAILED");
        }
    }
}
