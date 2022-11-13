package test;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import sudoku.Generator;

import sudoku.Grid;
import sudoku.Grid.Cell;
import sudoku.Solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sudoku.Grid.*;

class GridTest {

	/**
	 * Test null grid exception
	 */
	@Test
	void verifyGridNullTest() {
		String expectedMessage = "Grid must not be null";
		int[][] nullGrid = null;
		Exception exception = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(nullGrid));

		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	/**
	 * Test row grid exception
	 */
	@Test
	void verifyGridRowTest() {
		String expectedMessage = "Grid must have nine rows";

		// with one row
		int[][] rowGrid1 = new int[1][9];
		Exception exception1 = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(rowGrid1));
		String actualMessage1 = exception1.getMessage();
		assertTrue(actualMessage1.contains(expectedMessage));

		// with zero row
		int[][] rowGrid2 = new int[0][9];
		Exception exception2 = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(rowGrid2));
		String actualMessage2 = exception2.getMessage();
		assertTrue(actualMessage2.contains(expectedMessage));

		// with ten rows
		int[][] rowGrid3 = new int[10][9];
		Exception exception3 = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(rowGrid3));
		String actualMessage3 = exception3.getMessage();
		assertTrue(actualMessage3.contains(expectedMessage));

		// with eight rows
		int[][] rowGrid4 = new int[8][9];
		Exception exception4 = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(rowGrid4));
		String actualMessage4 = exception4.getMessage();
		assertTrue(actualMessage4.contains(expectedMessage));
	}

	/**
	 * Test column grid exception
	 */
	@Test
	void verifyGridColumnTest() {
		String expectedMessage = "Grid must have nine columns";

		// with one column
		int[][] colGrid1 = new int[9][1];
		Exception exception1 = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(colGrid1));
		String actualMessage1 = exception1.getMessage();
		assertTrue(actualMessage1.contains(expectedMessage));

		// with ten column
		int[][] colGrid2 = new int[9][10];
		Exception exception2 = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(colGrid2));
		String actualMessage2 = exception2.getMessage();
		assertTrue(actualMessage2.contains(expectedMessage));

		// with eight column
		int[][] colGrid3 = new int[9][8];
		Exception exception3 = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(colGrid3));
		String actualMessage3 = exception3.getMessage();
		assertTrue(actualMessage3.contains(expectedMessage));

		// with zero column
		int[][] colGrid4 = new int[9][0];
		Exception exception4 = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(colGrid4));
		String actualMessage4 = exception4.getMessage();
		assertTrue(actualMessage4.contains(expectedMessage));
	}
	
	/**
	 * Test values grid exception
	 */
	@Test
	void verifyGridValueTest() {
		String expectedMessage = "Grid must contain values from 0-9";

		// with 10 value
		int[][] numGrid1 = new int[][]{
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
		Exception exception1 = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(numGrid1));
		String actualMessage1 = exception1.getMessage();
		assertTrue(actualMessage1.contains(expectedMessage));
		
		// with -1 value
				int[][] numGrid2 = new int[][]{
		            {-1, 0, 0, 6, 0, 2, 0, 0, 0},
		            {1, 0, 0, 6, 0, 2, 0, 0, 0},
		            {0, 0, 0, 6, 0, 2, 0, 0, 0},
		            {0, 0, 0, 6, 0, 2, 0, 0, 0},
		            {0, 0, 0, 6, 0, 2, 0, 0, 0},
		            {0, 0, 0, 6, 0, 2, 0, 0, 0},
		            {0, 8, 7, 9, 4, 3, 2, 0, 0},
		            {0, 0, 0, 6, 0, 2, 0, 0, 0},
		            {0, 0, 0, 6, 0, 2, 0, 0, 0}
		        };
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> Grid.verifyGrid(numGrid2));
				String actualMessage2 = exception2.getMessage();
				assertTrue(actualMessage2.contains(expectedMessage));
	}
	
	/**
	 * Test values grid exception
	 */
	@Test
	void verifyGridValidTest() {        
        int[][] validGrid = new int[][]{
            {1, 0, 0, 6, 0, 2, 0, 0, 0},
            {1, 0, 0, 6, 0, 2, 0, 0, 0},
            {0, 0, 0, 6, 0, 2, 0, 0, 0},
            {0, 0, 0, 6, 0, 2, 0, 0, 0},
            {0, 0, 0, 6, 0, 2, 0, 0, 0},
            {0, 0, 0, 6, 0, 2, 0, 0, 0},
            {0, 8, 7, 9, 4, 3, 2, 0, 0},
            {0, 0, 0, 6, 0, 2, 0, 0, 0},
            {0, 0, 0, 6, 0, 2, 0, 0, 0}
        };		
		Assertions.assertDoesNotThrow(() -> Grid.verifyGrid(validGrid));
    	}
	
	@Test
	void verifyGridTest() {
		verifyGridNullTest();
		verifyGridRowTest();
		verifyGridColumnTest();
		verifyGridValueTest();
		verifyGridValidTest();
	}

	@Test
	void ofTest() {
		Grid grid = emptyGrid();
		Grid test = Grid.of(new int[9][9]);
		assertArrayEquals(test.tab(), grid.tab());
	}

	@Test
	void emptyGridTest() {
		Cell[][] testcells = new Cell[9][9];
		for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++) {
				Cell cell = new Cell(0);
				testcells[row][column] = cell;
			}
		}
		Grid testgrid = new Grid(testcells);

		Grid test = emptyGrid();

		assertEquals(testgrid.toString(), test.toString());
	}

	@Test
	void isValidValueForCellTest() {
		Grid testgrid = emptyGrid();
		Cell testcell = testgrid.getCell(0, 0);
		boolean test = testgrid.isValidValueForCell(testcell, 1);
		assertEquals(test, true);

		Grid grid;
		int[][] numgrid = new int[][] { { 1, 0, 0, 0, 0, 0, 0, 0, 5 }, { 2, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 3, 0, 0, 0, 0, 0, 0, 0, 0 }, { 4, 0, 9, 0, 0, 0, 0, 0, 0 }, { 5, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 6, 0, 0, 0, 0, 0, 0, 0, 0 }, { 7, 0, 1, 0, 0, 0, 0, 0, 0 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 9, 0, 0, 0, 0, 0, 0, 0, 0 } };
		grid = of(numgrid);
		Cell rowcell = grid.getCell(0, 1);
		boolean testfalserow = grid.isValidValueForCell(rowcell, 5);
		assertEquals(testfalserow, false);

		Cell colcell = grid.getCell(0, 2);
		boolean testfalsecol = grid.isValidValueForCell(colcell, 9);
		assertEquals(testfalsecol, false);

		Cell boxcell = grid.getCell(2, 2);
		boolean testfalsebox = grid.isValidValueForCell(boxcell, 1);
		assertEquals(testfalsebox, false);
		
		Cell allcell = grid.getCell(0, 2);
		boolean testfalse = grid.isValidValueForCell(allcell, 1);
		assertEquals(testfalse, false);
	}

	@Test
	void tabTest() {
		Grid testgrid = emptyGrid();
		int[][] grid = new int[9][9];
		for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++) {
				grid[row][column] = 0;
			}
		}
		assertArrayEquals(grid, testgrid.tab());
	}

	@Test
	void getFirstEmptyCellTest() {
		// first cell is empty
		Grid grid1 = Grid.emptyGrid();
		Optional<Cell> emptyCellTest1 = grid1.getFirstEmptyCell();
		Optional<Cell> emptyCell1 = Optional.of(grid1.getCell(0, 0));
		assertEquals(emptyCellTest1, emptyCell1);	
		
		// first cell is not empty
		Grid grid2 = Grid.emptyGrid();
		grid2.setCellValue(0, 0, 1);
		Optional<Cell> emptyCellTest2 = grid2.getFirstEmptyCell();
		Optional<Cell> emptyCell2 = Optional.of(grid2.getCell(0, 1));
		assertEquals(emptyCellTest2, emptyCell2);	
	}

	@Test
	void getNextEmptyCellOfTest() {
		// No cell is empty after the first one
		Generator generator = new Generator(new Solver());
		Grid grid = generator.generate(0);
		grid.setCellValue(0, 0, 0);
		Optional<Cell> emptyCellTest = grid.getNextEmptyCellOf(grid.getCell(0, 0));
		Optional<Cell> emptyCell = Optional.empty();
		assertEquals(emptyCellTest, emptyCell);		
	}

	@Test
	void addTest() {
		int[][] numgrid = new int[][] { { 1, 0, 0, 0, 0, 0, 0, 0, 9 }, { 2, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 3, 0, 0, 0, 0, 0, 0, 0, 0 }, { 4, 0, 0, 0, 0, 0, 0, 0, 0 }, { 5, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 6, 0, 0, 0, 0, 0, 0, 0, 0 }, { 7, 0, 0, 0, 0, 0, 0, 0, 0 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 9, 0, 0, 0, 0, 0, 0, 0, 0 } };
		Grid testgrid = Grid.of(numgrid);
		testgrid.setInitialGrid(testgrid);
		// Condition Coverage
		assertFalse(testgrid.add(1, 0, 1));
		assertFalse(testgrid.add(7, 0, 0));
		assertTrue(testgrid.add(1, 0, 5));
		// With the condition coverage and the assert below. Decision Coverage
		assertFalse(testgrid.add(1, 0, -1));
	}

	@Test
	void StringConverterTest() {
		int[][] numgrid = new int[][] { { 4, 5, 3, 8, 2, 6, 1, 9, 7 }, { 8, 9, 2, 5, 7, 1, 6, 3, 4 },
				{ 1, 6, 7, 4, 9, 3, 5, 2, 8 }, { 7, 1, 4, 9, 5, 2, 8, 6, 3 }, { 5, 8, 6, 1, 3, 7, 2, 4, 9 },
				{ 3, 2, 9, 6, 8, 4, 7, 5, 1 }, { 9, 3, 5, 2, 1, 8, 4, 7, 6 }, { 6, 7, 1, 3, 4, 5, 9, 8, 2 },
				{ 2, 4, 8, 7, 6, 9, 3, 1, 5 } };
		Grid testgrid = Grid.of(numgrid);
		testgrid.setInitialGrid(testgrid);
		String grid = "  ║ A │ B │ C ║ D │ E │ F ║ G │ H │ I ║\n" + "══╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n"
				+ "1 ║ 4 │ 5 │ 3 ║ 8 │ 2 │ 6 ║ 1 │ 9 │ 7 ║\n" + "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n"
				+ "2 ║ 8 │ 9 │ 2 ║ 5 │ 7 │ 1 ║ 6 │ 3 │ 4 ║\n" + "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n"
				+ "3 ║ 1 │ 6 │ 7 ║ 4 │ 9 │ 3 ║ 5 │ 2 │ 8 ║\n" + "══╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n"
				+ "4 ║ 7 │ 1 │ 4 ║ 9 │ 5 │ 2 ║ 8 │ 6 │ 3 ║\n" + "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n"
				+ "5 ║ 5 │ 8 │ 6 ║ 1 │ 3 │ 7 ║ 2 │ 4 │ 9 ║\n" + "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n"
				+ "6 ║ 3 │ 2 │ 9 ║ 6 │ 8 │ 4 ║ 7 │ 5 │ 1 ║\n" + "══╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n"
				+ "7 ║ 9 │ 3 │ 5 ║ 2 │ 1 │ 8 ║ 4 │ 7 │ 6 ║\n" + "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n"
				+ "8 ║ 6 │ 7 │ 1 ║ 3 │ 4 │ 5 ║ 9 │ 8 │ 2 ║\n" + "──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n"
				+ "9 ║ 2 │ 4 │ 8 ║ 7 │ 6 │ 9 ║ 3 │ 1 │ 5 ║\n" + "══╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝\n";
		assertEquals(grid, testgrid.toString());
	}

	@Test
	void getInitialGridTest() {
		int[][] numgrid = new int[][] { { 4, 5, 3, 8, 2, 6, 1, 9, 7 }, { 8, 9, 2, 5, 7, 1, 6, 3, 4 },
				{ 1, 6, 7, 4, 9, 3, 5, 2, 8 }, { 7, 1, 4, 9, 5, 2, 8, 6, 3 }, { 5, 8, 6, 1, 3, 7, 2, 4, 9 },
				{ 3, 2, 9, 6, 8, 4, 7, 5, 1 }, { 9, 3, 5, 2, 1, 8, 4, 7, 6 }, { 6, 7, 1, 3, 4, 5, 9, 8, 2 },
				{ 2, 4, 8, 7, 6, 9, 3, 1, 5 } };
		Grid testgrid = Grid.of(numgrid);
		testgrid.setInitialGrid(testgrid);
		assertEquals(testgrid.getInitialGrid().toString(), testgrid.toString());
	}

	@Test
	void setInitialGridTest() {
		int[][] numgrid = new int[][] { { 4, 5, 3, 8, 2, 6, 1, 9, 7 }, { 8, 9, 2, 5, 7, 1, 6, 3, 4 },
				{ 1, 6, 7, 4, 9, 3, 5, 2, 8 }, { 7, 1, 4, 9, 5, 2, 8, 6, 3 }, { 5, 8, 6, 1, 3, 7, 2, 4, 9 },
				{ 3, 2, 9, 6, 8, 4, 7, 5, 1 }, { 9, 3, 5, 2, 1, 8, 4, 7, 6 }, { 6, 7, 1, 3, 4, 5, 9, 8, 2 },
				{ 2, 4, 8, 7, 6, 9, 3, 1, 5 } };
		Grid testgrid = Grid.of(numgrid);
		testgrid.setInitialGrid(testgrid);
		assertEquals(testgrid.getInitialGrid().toString(), testgrid.toString());
	}

	@Test
	void getSizeTest() {
		int[][] numgrid = new int[][] { { 4, 5, 3, 8, 2, 6, 1, 9, 7 }, { 8, 9, 2, 5, 7, 1, 6, 3, 4 },
				{ 1, 6, 7, 4, 9, 3, 5, 2, 8 }, { 7, 1, 4, 9, 5, 2, 8, 6, 3 }, { 5, 8, 6, 1, 3, 7, 2, 4, 9 },
				{ 3, 2, 9, 6, 8, 4, 7, 5, 1 }, { 9, 3, 5, 2, 1, 8, 4, 7, 6 }, { 6, 7, 1, 3, 4, 5, 9, 8, 2 },
				{ 2, 4, 8, 7, 6, 9, 3, 1, 5 } };
		Grid testgrid = Grid.of(numgrid);
		testgrid.setInitialGrid(testgrid);
		int len = testgrid.getSize();
		assertEquals(9, len);
	}

	@Test
	void getCellTest() {
		int[][] numgrid = new int[][] { { 4, 5, 3, 8, 2, 6, 1, 9, 7 }, { 8, 9, 2, 5, 7, 1, 6, 3, 4 },
				{ 1, 6, 7, 4, 9, 3, 5, 2, 8 }, { 7, 1, 4, 9, 5, 2, 8, 6, 3 }, { 5, 8, 6, 1, 3, 7, 2, 4, 9 },
				{ 3, 2, 9, 6, 8, 4, 7, 5, 1 }, { 9, 3, 5, 2, 1, 8, 4, 7, 6 }, { 6, 7, 1, 3, 4, 5, 9, 8, 2 },
				{ 2, 4, 8, 7, 6, 9, 3, 1, 5 } };
		Grid testgrid = Grid.of(numgrid);
		testgrid.setInitialGrid(testgrid);
		Cell testcell = testgrid.getCell(0, 0);
		assertEquals(testcell.getValue(),4);
	}

	@Test
	void setCellValueTest() {
		int[][] numgrid = new int[][] { { 4, 5, 3, 8, 2, 6, 1, 9, 7 }, { 8, 9, 2, 5, 7, 1, 6, 3, 4 },
				{ 1, 6, 7, 4, 9, 3, 5, 2, 8 }, { 7, 1, 4, 9, 5, 2, 8, 6, 3 }, { 5, 8, 6, 1, 3, 7, 2, 4, 9 },
				{ 3, 2, 9, 6, 8, 4, 7, 5, 1 }, { 9, 3, 5, 2, 1, 8, 4, 7, 6 }, { 6, 7, 1, 3, 4, 5, 9, 8, 2 },
				{ 2, 4, 8, 7, 6, 9, 3, 1, 5 } };
		Grid testgrid = Grid.of(numgrid);
		testgrid.setInitialGrid(testgrid);
		testgrid.setCellValue(0, 0, 1);
		Cell testcell = testgrid.getCell(0, 0);
		assertEquals(testcell.getValue(), 1);
	}

	@Test
	void getValueTest() {
		Cell testcell = new Cell(1);
		assertEquals(testcell.getValue(),1);
	}

	@Test
	void setValueTest() {
		Cell testcell = new Cell(1);
		testcell.setValue(2);
		assertEquals(testcell.getValue(),2);
	}

	@Test
	void isEmptyTest() {
		Cell testcell = new Cell(0);
		assertTrue(testcell.isEmpty());
		testcell.setValue(1);
		assertFalse(testcell.isEmpty());
	}

	@Test
	void getRowNeighborsTest() {
		Cell testcell = new Cell(1);
		Cell testcell2 = new Cell(2);
		Cell testcell3 = new Cell(3);
		List<Cell> listcell = new ArrayList<>();
		listcell.add(testcell2);
		listcell.add(testcell3);
		testcell.setRowNeighbors(listcell);
		int i = 0;
		int[] test = new int[] { 2, 3 };
		for (Cell neighbor : testcell.getRowNeighbors()) {
			assertEquals(neighbor.getValue(),test[i]);
			i++;
		}
	}

	@Test
	void setRowNeighborsTest() {
		Cell testcell = new Cell(1);
		Cell testcell2 = new Cell(2);
		Cell testcell3 = new Cell(3);
		List<Cell> listcell = new ArrayList<>();
		listcell.add(testcell2);
		listcell.add(testcell3);
		testcell.setRowNeighbors(listcell);
		int i = 0;
		int[] test = new int[] { 2, 3 };
		for (Cell neighbor : testcell.getRowNeighbors()) {
			assertEquals(neighbor.getValue(), test[i]);
			i++;
		}
	}

	@Test
	void getColumnNeighborsTest() {
		Cell testcell = new Cell(1);
		Cell testcell2 = new Cell(2);
		Cell testcell3 = new Cell(3);
		List<Cell> listcell = new ArrayList<>();
		listcell.add(testcell2);
		listcell.add(testcell3);
		testcell.setColumnNeighbors(listcell);
		int i = 0;
		int[] test = new int[] { 2, 3 };
		for (Cell neighbor : testcell.getColumnNeighbors()) {
			assertEquals(neighbor.getValue(), test[i]);
			i++;
		}
	}

	@Test
	void setColumnNeighborsTest() {
		Cell testcell = new Cell(1);
		Cell testcell2 = new Cell(2);
		Cell testcell3 = new Cell(3);
		List<Cell> listcell = new ArrayList<>();
		listcell.add(testcell2);
		listcell.add(testcell3);
		testcell.setColumnNeighbors(listcell);
		int i = 0;
		int[] test = new int[] { 2, 3 };
		for (Cell neighbor : testcell.getColumnNeighbors()) {
			assertEquals(neighbor.getValue(), test[i]);
			i++;
		}
	}

	@Test
	void getNextCellTest() {
		Cell testcell = new Cell(1);
		Cell testcell2 = new Cell(2);
		testcell.setNextCell(testcell2);
		assertEquals(testcell.getNextCell(), testcell2);
	}

	@Test
	void setNextCellTest() {
		Cell testcell = new Cell(1);
		Cell testcell2 = new Cell(2);
		testcell.setNextCell(testcell2);
		assertEquals(testcell.getNextCell(), testcell2);
	}
}
