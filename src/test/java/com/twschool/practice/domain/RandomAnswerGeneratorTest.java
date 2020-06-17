package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Test;

public class RandomAnswerGeneratorTest {

    @Test
    public void should_generate_valid_answer() {
        RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
        
        Answer answer = randomAnswerGenerator.generateAnswer();

        Assert.assertNotNull(answer);
        Assert.assertTrue(answer.isValidFormat());
    }
}
