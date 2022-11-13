package test;

import sudoku.DBInterface;

public class MockDB implements DBInterface {

	@Override
	public int[][] query(String q) {
		switch (q) {
		case "1":
			int[][] easyGrid = new int[][]{
	            {0, 2, 3, 4, 5, 6, 7, 8, 9},
	            {4, 0, 6, 7, 8, 9, 1, 2, 3},
	            {7, 8, 9, 0, 2, 3, 4, 5, 6},
	            {2, 1, 4, 3, 6, 5, 8, 9, 7},
	            {3, 6, 5, 8, 0, 7, 2, 1, 4},
	            {8, 9, 0, 2, 1, 4, 3, 6, 5},
	            {5, 3, 1, 6, 4, 0, 9, 7, 8},
	            {6, 4, 2, 9, 7, 8, 5, 3, 1},
	            {9, 7, 8, 0, 3, 0, 6, 4, 2}
	        };
	        return easyGrid;
		case "2":
			int[][] difficultGrid = new int[][]{
	            {0, 0, 3, 4, 5, 6, 7, 0, 0},
	            {4, 0, 0, 7, 8, 9, 1, 2, 3},
	            {7, 0, 0, 0, 2, 3, 4, 0, 0},
	            {2, 0, 0, 0, 0, 0, 0, 9, 7},
	            {3, 6, 0, 8, 0, 7, 2, 0, 0},
	            {8, 0, 0, 2, 1, 4, 0, 6, 5},
	            {5, 3, 0, 6, 4, 0, 9, 7, 0},
	            {6, 4, 2, 9, 7, 8, 0, 3, 1},
	            {9, 0, 8, 0, 3, 0, 0, 0, 0}
	        };
	        return difficultGrid;
		default:
			System.out.println("Invalid selection.");
		}
		return null;
	}

}
