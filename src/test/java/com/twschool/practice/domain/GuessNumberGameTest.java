package com.twschool.practice.domain;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class GuessNumberGameTest {
    
    private GuessNumberGame guessNumberGame;

    @Before
    public void setUp() throws Exception {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
    }

    @Test
    public void should_return_4A0B_when_input_1234_given_answer_1234() {
        String result = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));

        Assert.assertEquals("4A0B", result);
    }

    @Test
    public void should_return_2A2B_when_input_1243_given_answer_1234() {
        String result = guessNumberGame.guess(Arrays.asList("1", "2", "4", "3"));

        Assert.assertEquals("2A2B", result);
    }

    @Test
    public void should_return_succeed_when_get_status_after_input_correct_answer() {
        guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        
        GameStatus gameStatus = guessNumberGame.getStatus();

        Assert.assertEquals(GameStatus.SUCCEED, gameStatus);
    }

    @Test
    public void should_return_continued_when_get_status_after_input_incorrect_answer() {
        guessNumberGame.guess(Arrays.asList("1", "3", "2", "4"));

        GameStatus gameStatus = guessNumberGame.getStatus();

        Assert.assertEquals(GameStatus.CONTINUED, gameStatus);
    }

    @Test
    public void should_return_failed_when_get_status_after_input_incorrect_answer_6_times() {
        guessNumberGame.guess(Arrays.asList("1", "3", "2", "4"));
        guessNumberGame.guess(Arrays.asList("1", "3", "2", "4"));
        guessNumberGame.guess(Arrays.asList("1", "3", "2", "4"));
        guessNumberGame.guess(Arrays.asList("1", "3", "2", "4"));
        guessNumberGame.guess(Arrays.asList("1", "3", "2", "4"));
        guessNumberGame.guess(Arrays.asList("1", "3", "2", "4"));

        GameStatus gameStatus = guessNumberGame.getStatus();

        Assert.assertEquals(GameStatus.FAILED, gameStatus);
    }

}
