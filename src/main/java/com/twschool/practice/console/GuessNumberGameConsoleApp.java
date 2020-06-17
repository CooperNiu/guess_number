package com.twschool.practice.console;

import com.twschool.practice.domain.RandomAnswerGenerator;

public class GuessNumberGameConsoleApp {
    
    public static void main(String[] args) {
        GuessNumberGameConsole guessNumberGameConsole = new GuessNumberGameConsole(new RandomAnswerGenerator(), new ConsoleInputReader(), new ConsoleOutputWriter());
        guessNumberGameConsole.play();
    }
}
