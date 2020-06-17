package com.twschool.practice.domain;

import com.twschool.practice.domain.Answer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AnswerTest {

    @Test
    public void should_return_4A0B_when_input_1234_given_answer_1234() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));
        
        String result = answer.check(Arrays.asList("1", "2", "3", "4"));

        Assert.assertEquals("4A0B", result);
    }

    @Test
    public void should_return_2A2B_when_input_1243_given_answer_1234() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));

        String result = answer.check(Arrays.asList("1", "2", "4", "3"));

        Assert.assertEquals("2A2B", result);
    }

    @Test
    public void should_return_0A4B_when_input_4321_given_answer_1234() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));

        String result = answer.check(Arrays.asList("4", "3", "2", "1"));

        Assert.assertEquals("0A4B", result);
    }

    @Test
    public void should_return_1A1B_when_input_1356_given_answer_1234() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));

        String result = answer.check(Arrays.asList("1", "3", "5", "6"));

        Assert.assertEquals("1A1B", result);
    }

    @Test
    public void should_return_0A1B_when_input_4567_given_answer_1234() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));

        String result = answer.check(Arrays.asList("4", "5", "6", "7"));

        Assert.assertEquals("0A1B", result);
    }

    @Test
    public void should_return_0A0B_when_input_5678_given_answer_1234() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));

        String result = answer.check(Arrays.asList("5", "6", "7", "8"));

        Assert.assertEquals("0A0B", result);
    }

    @Test
    public void should_return_false_when_check_answer_format_given_answer_12() {
        Answer answer = new Answer(Arrays.asList("1", "2"));
        
        Assert.assertEquals(false, answer.isValidFormat());
    }

    @Test
    public void should_return_true_when_check_answer_format_given_answer_1234() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));

        Assert.assertEquals(true, answer.isValidFormat());
    }

    @Test
    public void should_return_false_when_check_answer_format_given_answer_1233() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "3"));

        Assert.assertEquals(false, answer.isValidFormat());
    }

    @Test
    public void should_return_false_when_check_answer_format_given_answer_abcd() {
        Answer answer = new Answer(Arrays.asList("a", "b", "c", "d"));

        Assert.assertEquals(false, answer.isValidFormat());
    }
}
