package test;

import org.junit.After;
import org.junit.Before;
import sudoku.GeneratorInterface;
import sudoku.Play;
import org.junit.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class PlayTest {
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

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
    @Test
    void playSolveTest() throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        final String testString = "1\n"+
                                  "60\n"+
                                  "2\n"+
                                  "2";
        provideInput(testString);
        Play play = new Play();
        GeneratorInterface gen = new MockGenerator();
        play.play(1, gen);
        Path path = Path.of("output.txt");
        Path path1 = Path.of("TestSolver.txt");
        System.setOut(systemOut);
        String output = new String(Files.readAllBytes(path));
        String test = new String(Files.readAllBytes(path1));
        assertEquals(output, test);
    }

    @Test
    void playExitTest() throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        final String testString = "10\n"+"2\n";
        provideInput(testString);
        Play play = new Play();
        GeneratorInterface gen = new MockGenerator();
        play.play(1, gen);
        Path path = Path.of("output.txt");
        Path path1 = Path.of("TestExit.txt");
        System.setOut(systemOut);
        String output = new String(Files.readAllBytes(path));
        String test = new String(Files.readAllBytes(path1));
        assertEquals(output,test);
    }

    @Test
    void playComplexityTest() throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        final String testStr =    "1\n"+
                                  "0\n"+
                                  "81\n"+
                                  "B1\n"+
                                  "-10\n"+
                                  "100\n";
        provideInput(testStr);
        Play play = new Play();
        GeneratorInterface gen = new MockGenerator();
        play.play(1, gen);
        Path path = Path.of("output.txt");
        Path path1 = Path.of("TestComplexity.txt");
        System.setOut(systemOut);
        String output = new String(Files.readAllBytes(path));
        String test = new String(Files.readAllBytes(path1));
        assertEquals(output,test);
    }

    @Test
    void playCellParserTest() throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        final String testString = "1\n"+
                                  "10\n"+
                                  "1\n"+
                                  "B1\n"+
                                  "5\n"+
                                  "1\n"+
                                  "1\n"+
                                  "1\n"+
                                  "A1\n"+
                                  "1\n"+
                                  "3\n"+
                                  "2";

        provideInput(testString);
        Play play = new Play();
        GeneratorInterface gen = new MockGenerator();
        play.play(1, gen);
        Path path = Path.of("output.txt");
        Path path1 = Path.of("TestCellParser.txt");
        System.setOut(systemOut);
        String output = new String(Files.readAllBytes(path));
        String test = new String(Files.readAllBytes(path1));
        assertEquals(output,test);
    }

    @Test
    void playCompleteTest() throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        final String testString = "1\n"+
                                  "10\n"+
                                  "1\n"+ "B1\n"+ "5\n"+
                                  "1\n"+ "B3\n"+ "6\n"+
                                  "1\n"+ "B5\n"+ "8\n"+
                                  "1\n"+ "B7\n"+ "3\n"+
                                  "1\n"+ "B9\n"+ "4\n"+
                                  "1\n"+ "E6\n"+ "8\n"+
                                  "1\n"+ "E8\n"+ "4\n"+
                                  "1\n"+ "F4\n"+ "2\n"+
                                  "1\n"+ "I1\n"+ "7\n"+
                                  "1\n"+ "I3\n"+ "8\n"+
                                  "1\n"+ "I5\n"+ "9\n"+
                                  "1\n"+ "I7\n"+ "6\n"+
                                  "1\n"+ "I9\n"+ "5\n"+
                                  "1\n"+ "C6\n"+ "9\n"+
                                  "1\n"+ "H2\n"+ "3\n"+
                                  "1\n"+ "H4\n"+ "6\n"+
                                  "2";

        provideInput(testString);
        Play play = new Play();
        GeneratorInterface gen = new MockGenerator();
        play.play(1, gen);
        Path path = Path.of("output.txt");
        Path path1 = Path.of("TestComplete.txt");
        System.setOut(systemOut);
        String output = new String(Files.readAllBytes(path));
        String test = new String(Files.readAllBytes(path1));
        assertEquals(output,test);
    }
}