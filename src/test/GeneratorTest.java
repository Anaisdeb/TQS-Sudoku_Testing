package test;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import sudoku.Generator;
import sudoku.Grid;

class GeneratorTest {

    @Test
    void generateTest() throws FileNotFoundException {
        Generator gen = new Generator(new MockSolver());
        Grid testgrid = Grid.emptyGrid();
        testgrid = gen.generate(1);
        System.out.println(testgrid.toString());
    }
}