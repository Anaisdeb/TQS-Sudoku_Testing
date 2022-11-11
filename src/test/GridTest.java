package test;

import sudoku.Grid;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.Grid.*;

class GridTest {

    @org.junit.jupiter.api.Test
    void verifyGridTest(){
        Throwable nullexception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Grid grid;
                    verifyGrid(null);
                }
        );
        assertEquals("Grid must not be null", nullexception.getMessage());

        Throwable rowexception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Grid grid;
                    int[][] rowgrid = new int[1][9];
                    verifyGrid(rowgrid);
                }
        );
        assertEquals("Grid must have nine rows", rowexception.getMessage());

        Throwable colexception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Grid grid;
                    int[][] colgrid = new int[9][1];
                    verifyGrid(colgrid);
                }
        );
        assertEquals("Grid must have nine columns", colexception.getMessage());

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Grid grid;
                    int[][] numgrid = new int[][]{
                        {10, 0, 0, 6, 0, 2, 0, 0, 0},{1, 0, 0, 6, 0, 2, 0, 0, 0},{0, 0, 0, 6, 0, 2, 0, 0, 0},
                        {0, 0, 0, 6, 0, 2, 0, 0, 0},{0, 0, 0, 6, 0, 2, 0, 0, 0},{0, 0, 0, 6, 0, 2, 0, 0, 0},
                        {0, 8, 7, 9, 4, 3, 2, 0, 0},{0, 0, 0, 6, 0, 2, 0, 0, 0},{0, 0, 0, 6, 0, 2, 0, 0, 0}
                    };
                    verifyGrid(numgrid);
                }
        );
        assertEquals("Grid must contain values from 0-9", exception.getMessage());

        Grid grid;
        int[][] validgrid = new int[9][9];
        verifyGrid(validgrid);
    }

    @org.junit.jupiter.api.Test
    void ofTest() {
        Grid testgrid = emptyGrid();
        testgrid.setInitialGrid(Grid.of(testgrid.tab()));
        testgrid.add(0,0,1);
        testgrid.add(1,0,2);
        testgrid.add(2,0,3);
        testgrid.add(3,0,4);
        testgrid.add(4,0,5);
        testgrid.add(5,0,6);
        testgrid.add(6,0,7);
        testgrid.add(7,0,8);
        testgrid.add(8,0,9);

        int[][] numgrid = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 0},{2, 0, 0, 0, 0, 0, 0, 0, 0},{3, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 0},{5, 0, 0, 0, 0, 0, 0, 0, 0},{6, 0, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},{8, 0, 0, 0, 0, 0, 0, 0, 0},{9, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        Grid grid = Grid.of(numgrid);
        assert(testgrid == grid):"of function";
    }

    @org.junit.jupiter.api.Test
    void isValidValueForCellTest() {
        Grid testgrid = emptyGrid();
        Cell testcell = testgrid.getCell(0,0);
        boolean test = testgrid.isValidValueForCell(testcell, 1);
        assertEquals(test, true);

        Grid grid;
        int[][] numgrid = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 0},{2, 0, 0, 0, 0, 0, 0, 0, 0},{3, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 0},{5, 0, 0, 0, 0, 0, 0, 0, 0},{6, 0, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},{8, 0, 0, 0, 0, 0, 0, 0, 0},{9, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        grid = of(numgrid);
        Cell cell = grid.getCell(0,1);
        boolean testfalse = grid.isValidValueForCell(cell,1);
        assertEquals(testfalse, false);
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}