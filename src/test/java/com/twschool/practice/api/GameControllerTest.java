package com.twschool.practice.api;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private GuessNumberGame guessNumberGame;

    @Before
    public void setUp() throws Exception {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
    }

    @Test
    public void should_return_guess_result() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/game/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("guess", "1 2 3 4"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("1 2 3 4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("4A0B"));
    }

    @Test
    public void should_return_score_3_given_one_guess_fail() throws Exception {
        String result = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        mockMvc.perform(MockMvcRequestBuilders.get("/tryOnceScore/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("result", result))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.score").value("3"));
    }

    @Test
    public void should_return_score_f3_given_one_guess_fail() throws Exception {
        String result = guessNumberGame.guess(Arrays.asList("3", "3", "3", "4"));
        mockMvc.perform(MockMvcRequestBuilders.get("/tryOnceScore/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("result", result))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.score").value("-3"));
    }

    @Test
    public void should_return_score_11_given_3_guess_success() throws Exception {
        String[] result = new String[3];
        result[0] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[1] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[2] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));

        mockMvc.perform(MockMvcRequestBuilders.get("/trySeveralTimesScore/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("result", result))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.score").value("11"));
    }

    @Test
    public void should_return_score_20_given_5_guess_success() throws Exception {
        String[] result = new String[5];
        result[0] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[1] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[2] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[3] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[4] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));

        mockMvc.perform(MockMvcRequestBuilders.get("/trySeveralTimesScore/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("result", result))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.score").value("20"));
    }


    @Test
    public void should_return_score_25_given_6_guess_success() throws Exception {
        String[] result = new String[6];
        result[0] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[1] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[2] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[3] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[4] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));
        result[5] = guessNumberGame.guess(Arrays.asList("1", "2", "3", "4"));

        mockMvc.perform(MockMvcRequestBuilders.get("/trySeveralTimesScore/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("result", result))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.score").value("25"));
    }

}
