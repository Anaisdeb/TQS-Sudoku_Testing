package test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import sudoku.Grid;
import sudoku.Solver;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    void solveTestTrue() {
        int[][] testnumgrid = new int[][]{
                {4, 5, 3, 8, 2, 6, 1, 9, 0},
                {8, 9, 2, 5, 7, 1, 6, 3, 0},
                {1, 6, 7, 4, 9, 3, 5, 2, 0},
                {7, 1, 4, 9, 5, 2, 8, 6, 0},
                {5, 8, 6, 1, 3, 7, 2, 4, 0},
                {3, 2, 9, 6, 8, 4, 7, 5, 0},
                {9, 3, 5, 2, 1, 8, 4, 7, 0},
                {6, 7, 1, 3, 4, 5, 9, 8, 0},
                {2, 4, 8, 7, 6, 9, 3, 1, 0}
        };
        Grid testgrid = Grid.of(testnumgrid);
        testgrid.setInitialGrid(testgrid);

        Solver testsolver = new Solver();
        testsolver.solve(testgrid);

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
        Grid grid = Grid.of(numgrid);
        testgrid.setInitialGrid(testgrid);

        assertEquals(grid.toString(), testgrid.toString());
    }

    @Test
    void solveTestFalseIllegalState(){
        int[][] testnumgrid = new int[][]{
                {2, 0, 0, 9, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {5, 0, 2, 6, 0, 0, 4, 0, 7},
                {0, 0, 0, 0, 0, 4, 1, 0, 0},
                {0, 0, 0, 0, 9, 8, 0, 2, 3},
                {0, 0, 0, 0, 0, 3, 0, 0, 8},
                {0, 0, 5, 0, 1, 0, 0, 0, 0},
                {0, 0, 7, 0, 0, 0, 0, 0, 0}
        };
        Grid testgrid = Grid.of(testnumgrid);
        testgrid.setInitialGrid(testgrid);

        Solver testsolver = new Solver();
        String expectedMessage = "The provided grid is not solvable.";
		Exception exception = Assertions.assertThrows(Exception.class, () -> testsolver.solve(testgrid));
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void solveTestFalseGridFull(){
        int[][] testnumgrid = new int[][]{
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
        Grid testgrid = Grid.of(testnumgrid);
        testgrid.setInitialGrid(testgrid);

        Solver testsolver = new Solver();
        testsolver.solve(testgrid);

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
        Grid grid = Grid.of(numgrid);
        testgrid.setInitialGrid(testgrid);

        assertEquals(grid.toString(), testgrid.toString());
    }
}