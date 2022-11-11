package test;

import org.junit.jupiter.api.Test;
import sudoku.Play;


import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.Play.*;

class PlayTest {
    private static Scanner scanner;
    @Test
    void playCellParser() {
        System.out.println("Type 1, 5");
        Play.play();
    }
}