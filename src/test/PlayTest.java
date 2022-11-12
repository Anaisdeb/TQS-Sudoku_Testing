package test;

import org.junit.After;
import org.junit.Before;
import sudoku.Play;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.Play.*;

class PlayTest {
    private static Scanner scanner;
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
    @Test
    void playCellParser() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        final String testString = "1\n"+
                "60\n"+
                "2\n"+
                "2";
        provideInput(testString);
        Play play = new Play();
        play.play();
        //assertContains("output.txt","test1.txt");
    }
}