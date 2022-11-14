package test;

import org.junit.Test;

import sudoku.DB;
import sudoku.Generator;
import sudoku.Grid;
import sudoku.Grid.Cell;
import sudoku.Solver;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    public void generateTest(){
    	Generator generator = new Generator(new MockSolver(), new MockDB());
    	Grid test = generator.generate(0);
    	int[][] grid = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 1, 4, 3, 6, 5, 8, 9, 7},
            {3, 6, 5, 8, 9, 7, 2, 1, 4},
            {8, 9, 7, 2, 1, 4, 3, 6, 5},
            {5, 3, 1, 6, 4, 2, 9, 7, 8},
            {6, 4, 2, 9, 7, 8, 5, 3, 1},
            {9, 7, 8, 5, 3, 1, 6, 4, 2}
        };
    	assertArrayEquals(test.tab(), grid);
    }
    
    @Test
    public void eraseCellsTest() {
    	Generator generator = new Generator(new Solver(), new DB());
        Grid grid = generator.generate(50);
        int size = grid.getSize();
        int nbEmptyCells = 0;
        for (int row = 0; row < size; row++) {
          for (int column = 0; column < size; column++) {
            Cell cell = grid.getCell(row, column);
            if (cell.getValue() == 0) {
            	nbEmptyCells ++;
            }
          }
        }
        assertEquals(nbEmptyCells, 50);
    }
}
