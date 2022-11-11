package test;

import org.junit.Assert;
import sudoku.Grid;

import java.util.Arrays;
import java.util.Objects;

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
                        {10, 0, 0, 6, 0, 2, 0, 0, 0},
                        {1, 0, 0, 6, 0, 2, 0, 0, 0},
                        {0, 0, 0, 6, 0, 2, 0, 0, 0},
                        {0, 0, 0, 6, 0, 2, 0, 0, 0},
                        {0, 0, 0, 6, 0, 2, 0, 0, 0},
                        {0, 0, 0, 6, 0, 2, 0, 0, 0},
                        {0, 8, 7, 9, 4, 3, 2, 0, 0},
                        {0, 0, 0, 6, 0, 2, 0, 0, 0},
                        {0, 0, 0, 6, 0, 2, 0, 0, 0}
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

        Cell[][] testcells = new Cell[9][9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Cell cell = new Cell(0);
                testcells[row][column] = cell;
            }
        }
        Grid testgrid = new Grid(testcells);

        testgrid.setInitialGrid(testgrid);

        testgrid.setCellValue(0,0,1);
        testgrid.setCellValue(1,0,2);
        testgrid.setCellValue(2,0,3);
        testgrid.setCellValue(3,0,4);
        testgrid.setCellValue(4,0,5);
        testgrid.setCellValue(5,0,6);
        testgrid.setCellValue(6,0,7);
        testgrid.setCellValue(7,0,8);
        testgrid.setCellValue(8,0,9);

        int[][] numgrid = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        Grid grid = Grid.of(numgrid);

        //I'm doing this becouse i don't know how to make the class 100% equals, becouse cell have
        //      private Collection<Cell> rowNeighbors;
        //		private Collection<Cell> columnNeighbors;
        //		private Collection<Cell> boxNeighbors;
        //		private Cell nextCell;
        assert(Objects.equals(testgrid.toString(), grid.toString()));
    }

    @org.junit.jupiter.api.Test
    void emptyGridTest(){
        Cell[][] testcells = new Cell[9][9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Cell cell = new Cell(0);
                testcells[row][column] = cell;
            }
        }
        Grid testgrid = new Grid(testcells);

        Grid test = emptyGrid();

        assert(Objects.equals(testgrid.toString(), test.toString()));
    }

    @org.junit.jupiter.api.Test
    void isValidValueForCellTest() {
        Grid testgrid = emptyGrid();
        Cell testcell = testgrid.getCell(0,0);
        boolean test = testgrid.isValidValueForCell(testcell, 1);
        assertEquals(test, true);

        Grid grid;
        int[][] numgrid = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 5},
                {2, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 9, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        grid = of(numgrid);
        Cell rowcell = grid.getCell(0,1);
        boolean testfalserow = grid.isValidValueForCell(rowcell,5);
        assertEquals(testfalserow, false);

        Cell colcell = grid.getCell(0,2);
        boolean testfalsecol = grid.isValidValueForCell(colcell,9);
        assertEquals(testfalsecol, false);

        Cell boxcell = grid.getCell(2,2);
        boolean testfalsebox = grid.isValidValueForCell(boxcell,1);
        assertEquals(testfalsebox, false);
    }

    @org.junit.jupiter.api.Test
    void tabTest() {
        Grid testgrid = emptyGrid();
        int[][] grid = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                grid[row][column] = 0;
            }
        }
        assert(Arrays.deepEquals(grid, testgrid.tab()));
    }

    @org.junit.jupiter.api.Test
    void getFirstEmptyCellTest(){}

    @org.junit.jupiter.api.Test
    void getNextEmptyCellOfTest(){}

    @org.junit.jupiter.api.Test
    void addTest(){
        int[][] numgrid = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 9},
                {2, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        Grid testgrid = Grid.of(numgrid);
        testgrid.setInitialGrid(testgrid);
        //Condition Coverage
        boolean testfalse = testgrid.add(1,0,1);
        assert (!testfalse);
        boolean testFalseOn = testgrid.add(8,0,2);
        assert (!testFalseOn);
        boolean testtrue = testgrid.add(1,0,5);
        assert (testtrue);
        //With the condition coverage and the assert below. Decision Coverage
        boolean testdecision = testgrid.add(1,0,-1);
        assert (!testdecision);
    }

    @org.junit.jupiter.api.Test
    void StringConverterTest(){
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
        Grid testgrid = Grid.of(numgrid);
        testgrid.setInitialGrid(testgrid);
        String grid = "  ║ A │ B │ C ║ D │ E │ F ║ G │ H │ I ║\n" +
                      "══╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n" +
                      "1 ║ 4 │ 5 │ 3 ║ 8 │ 2 │ 6 ║ 1 │ 9 │ 7 ║\n" +
                      "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                      "2 ║ 8 │ 9 │ 2 ║ 5 │ 7 │ 1 ║ 6 │ 3 │ 4 ║\n" +
                      "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                      "3 ║ 1 │ 6 │ 7 ║ 4 │ 9 │ 3 ║ 5 │ 2 │ 8 ║\n" +
                      "══╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n" +
                      "4 ║ 7 │ 1 │ 4 ║ 9 │ 5 │ 2 ║ 8 │ 6 │ 3 ║\n" +
                      "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                      "5 ║ 5 │ 8 │ 6 ║ 1 │ 3 │ 7 ║ 2 │ 4 │ 9 ║\n" +
                      "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                      "6 ║ 3 │ 2 │ 9 ║ 6 │ 8 │ 4 ║ 7 │ 5 │ 1 ║\n" +
                      "══╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n" +
                      "7 ║ 9 │ 3 │ 5 ║ 2 │ 1 │ 8 ║ 4 │ 7 │ 6 ║\n" +
                      "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                      "8 ║ 6 │ 7 │ 1 ║ 3 │ 4 │ 5 ║ 9 │ 8 │ 2 ║\n" +
                      "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                      "9 ║ 2 │ 4 │ 8 ║ 7 │ 6 │ 9 ║ 3 │ 1 │ 5 ║\n" +
                      "══╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝\n";
        assert (Objects.equals(grid, testgrid.toString()));
    }
}