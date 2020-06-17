package com.twschool.practice.console;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

public class ConsoleOutputWriterTest {
    @Test
    public void should_write_output() {
        ConsoleOutputWriter consoleOutputWriter = new ConsoleOutputWriter();
        PrintStream printStream = Mockito.mock(PrintStream.class);
        System.setOut(printStream);
        
        consoleOutputWriter.output("succeed");
        
        Mockito.verify(printStream, Mockito.times(1)).println(Mockito.eq("succeed"));
    }
}
