package test;

import sudoku.DBInterface;

/**
 * Simulates the reading of an empty database thanks to the TestEmptyDB.txt file.
 */
public class MockDBEmpty implements DBInterface {

	@Override
	public int[][] query(String q) throws Exception {
		return getContent("TestQueryContent.txt");
	}
}