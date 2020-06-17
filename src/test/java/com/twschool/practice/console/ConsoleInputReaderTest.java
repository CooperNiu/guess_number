package com.twschool.practice.console;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleInputReaderTest {

    @Test
    public void should_read_input() {
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        String expected = "1 2 3 4";
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);
        
        String input = consoleInputReader.getInput();

        Assert.assertNotNull(input);
        Assert.assertEquals(expected, input);
    }
}
