package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sudoku.DB;

/**
 * Test the database access functions.
 */
class DBTest {
	
	/**
	 * Test an easy sudoku grid query.
	 * @throws Exception
	 */
	@Test
	void testQueryEasy() throws Exception {
		DB db = new DB();
		int[][] grid = db.query("1");
		int size = grid.length;
		int nbEmptyCells = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (grid[row][column] == 0) {
					nbEmptyCells++;
				}
			}
		}
		assertEquals(nbEmptyCells/40, 0);
	}
	
	/**
	 * Test a difficult sudoku grid query.
	 * @throws Exception
	 */
	@Test
	void testQueryDifficult() throws Exception {
		DB db = new DB();
		int[][] grid = db.query("2");
		int size = grid.length;
		int nbEmptyCells = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (grid[row][column] == 0) {
					nbEmptyCells++;
				}
			}
		}
		assertEquals(nbEmptyCells/40, 1);
	}
	
	/**
	 * Test reading an empty database.
	 */
	@Test
	void testGetContent() {
		DB db = new DB();
		Exception exception = Assertions.assertThrows(Exception.class, () -> db.getContent("TestQueryContent.txt"));

		String expectedMessage = "Incorrect database file.";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
}
