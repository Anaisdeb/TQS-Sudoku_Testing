package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sudoku.DB;
import sudoku.Grid.Cell;

class DBTest {

	@Test
	void testQueryEasy() {
		DB db = new DB();
		int[][] grid = db.query("1");
		int size = grid.length;
		int nbEmptyCells = 0;
        for (int row = 0; row < size; row++) {
          for (int column = 0; column < size; column++) {
            if (grid[row][column] == 0) {
            	nbEmptyCells ++;
            }
          }
        }
        assertTrue(nbEmptyCells < 40);
	}
	
	@Test
	void testQueryDifficult() {
		DB db = new DB();
		int[][] grid = db.query("2");
		int size = grid.length;
		int nbEmptyCells = 0;
        for (int row = 0; row < size; row++) {
          for (int column = 0; column < size; column++) {
            if (grid[row][column] == 0) {
            	nbEmptyCells ++;
            }
          }
        }
        assertTrue(nbEmptyCells > 40);
	}
}
