package com.twschool.practice.console;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.RandomAnswerGenerator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GuessNumberGameConsoleTest {
    
    private GuessNumberGameConsole guessNumberGameConsole;
    private RandomAnswerGenerator randomAnswerGenerator;
    
    @Before
    public void setUp() throws Exception {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));
        randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        
        guessNumberGameConsole = new GuessNumberGameConsole(randomAnswerGenerator, new ConsoleInputReader(), new ConsoleOutputWriter());
    }

    @Test
    public void should_output_Wrong_input_when_input_1134_given_game_with_answer_1234() {
        String result = guessNumberGameConsole.guess("1 1 3 4");

        assertEquals("Wrong Input，Input again", result);
    }

    @Test
    public void should_output_4A0B_when_input_1234_given_game_with_answer_1234() {
        String result = guessNumberGameConsole.guess("1 2 3 4");

        assertEquals("4A0B", result);
    }

    @Test
    public void should_play_until_game_end() {
        ConsoleInputReader consoleInputReader = Mockito.mock(ConsoleInputReader.class);
        Mockito.when(consoleInputReader.getInput()).thenReturn("1 2 5 6");
        GuessNumberGameConsole guessNumberGameConsole = Mockito.spy(new GuessNumberGameConsole(randomAnswerGenerator, consoleInputReader, new ConsoleOutputWriter()));

        guessNumberGameConsole.play();

        Mockito.verify(guessNumberGameConsole, Mockito.times(6)).guess(Mockito.any());
    }

    @Test
    public void should_not_guess_again_after_guess_succeed() {
        ConsoleInputReader consoleInputReader = Mockito.mock(ConsoleInputReader.class);
        Mockito.when(consoleInputReader.getInput()).thenReturn("1 2 3 4");
        GuessNumberGameConsole guessNumberGameConsole = Mockito.spy(new GuessNumberGameConsole(randomAnswerGenerator, consoleInputReader, new ConsoleOutputWriter()));

        guessNumberGameConsole.play();

        Mockito.verify(guessNumberGameConsole, Mockito.times(1)).guess(Mockito.any());
    }

    @Test
    public void should_not_output_guess_tips_again_after_guess_succeed() {
        ConsoleInputReader consoleInputReader = Mockito.mock(ConsoleInputReader.class);
        Mockito.when(consoleInputReader.getInput()).thenReturn("1 2 3 4");
        ConsoleOutputWriter consoleOutputWriter = Mockito.mock(ConsoleOutputWriter.class);
        GuessNumberGameConsole guessNumberGameConsole = Mockito.spy(new GuessNumberGameConsole(randomAnswerGenerator, consoleInputReader, consoleOutputWriter));

        guessNumberGameConsole.play();

        Mockito.verify(consoleOutputWriter, Mockito.times(1)).output(Mockito.eq("input answer: "));
    }
    
    @Test
    public void should_output_game_result_message_only_once_after_play_succeed() {
        ConsoleInputReader consoleInputReader = Mockito.mock(ConsoleInputReader.class);
        Mockito.when(consoleInputReader.getInput()).thenReturn("1 2 3 4");
        ConsoleOutputWriter consoleOutputWriter = Mockito.mock(ConsoleOutputWriter.class);
        GuessNumberGameConsole guessNumberGameConsole = Mockito.spy(new GuessNumberGameConsole(randomAnswerGenerator, consoleInputReader, consoleOutputWriter));

        guessNumberGameConsole.play();

        Mockito.verify(consoleOutputWriter, Mockito.times(1)).output(Mockito.eq("SUCCEED"));
        Mockito.verify(consoleOutputWriter, Mockito.times(0)).output(Mockito.eq("FAILED"));
    }

    @Test
    public void should_output_game_result_message_only_once_after_play_failed() {
        ConsoleInputReader consoleInputReader = Mockito.mock(ConsoleInputReader.class);
        Mockito.when(consoleInputReader.getInput()).thenReturn("1 2 3 5");
        ConsoleOutputWriter consoleOutputWriter = Mockito.mock(ConsoleOutputWriter.class);
        GuessNumberGameConsole guessNumberGameConsole = Mockito.spy(new GuessNumberGameConsole(randomAnswerGenerator, consoleInputReader, consoleOutputWriter));

        guessNumberGameConsole.play();

        Mockito.verify(consoleOutputWriter, Mockito.times(0)).output(Mockito.eq("SUCCEED"));
        Mockito.verify(consoleOutputWriter, Mockito.times(1)).output(Mockito.eq("FAILED"));
    }

}
