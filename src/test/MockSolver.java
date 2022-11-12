package test;

import sudoku.Grid;
import sudoku.SolverInterface;

public class MockSolver implements SolverInterface {
    @Override
    public void solve(Grid grid) {
        int[][] numgrid = new int[][]{
                {4, 5, 3, 8, 2, 6, 1, 9, 7},
                {8, 9, 2, 5, 7, 1, 6, 3, 4},
                {1, 6, 7, 4, 9, 3, 5, 2, 8},
                {7, 1, 4, 9, 5, 2, 8, 6, 3},
                {5, 8, 6, 1, 3, 7, 2, 4, 9},
                {3, 2, 9, 6, 8, 4, 7, 5, 1},
                {9, 3, 5, 2, 1, 8, 4, 7, 6},
                {6, 7, 1, 3, 4, 5, 9, 8, 2},
                {2, 4, 8, 7, 6, 9, 3, 1, 5}
        };
        Grid.Cell[][] testcells = new Grid.Cell[9][9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                grid.getCell(row,column).setValue(numgrid[row][column]);
            }
        }
    }
}
