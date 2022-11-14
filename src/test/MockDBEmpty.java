package test;

import sudoku.DBInterface;

public class MockDBEmpty implements DBInterface {

	@Override
	public int[][] query(String q) throws Exception {
		return getContent("TestQueryContent.txt");
	}
}