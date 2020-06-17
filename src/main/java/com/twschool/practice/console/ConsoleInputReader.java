package com.twschool.practice.console;

import java.util.Scanner;

public class ConsoleInputReader {
    public String getInput() {
        Scanner scanner = new Scanner(System.in) ;
        return scanner.nextLine();
    }
}
