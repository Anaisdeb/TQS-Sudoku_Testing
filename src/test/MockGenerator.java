package test;

import sudoku.GeneratorInterface;
import sudoku.Grid;

public class MockGenerator implements GeneratorInterface {
    @Override
    public Grid generate(int numberOfEmptyCells) {
        int[][] numgrid = new int[][]{
                {4, 0, 3, 8, 2, 6, 1, 9, 0},
                {8, 9, 2, 5, 7, 1, 6, 0, 4},
                {1, 0, 7, 4, 9, 3, 5, 2, 0},
                {7, 1, 4, 9, 5, 0, 8, 0, 3},
                {5, 0, 6, 1, 3, 7, 2, 4, 0},
                {3, 2, 0, 6, 0, 4, 7, 5, 1},
                {9, 0, 5, 2, 1, 8, 4, 7, 0},
                {6, 7, 1, 3, 0, 5, 9, 8, 2},
                {2, 0, 8, 7, 6, 9, 3, 1, 0}
        };
        Grid testgrid = Grid.of(numgrid);
        return testgrid;
    }
}
