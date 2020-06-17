package com.twschool.practice.domain;

public class User {
    private String id;
    private int successCount;
    private int score;
    private GuessNumberGame guessNumberGame;

    public User(String id, GuessNumberGame guessNumberGame, int successCount, int score) {
        this.id = id;
        this.successCount = successCount;
        this.score = score;
        this.guessNumberGame = guessNumberGame;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void subScore(int score) {
        this.score -= score;
    }

    public GuessNumberGame getGuessNumberGame() {
        return guessNumberGame;
    }

    public void setGuessNumberGame(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }
}
