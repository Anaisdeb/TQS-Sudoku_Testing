package sudoku;

/**
 * Implements the database interface.
 */
public class DB implements DBInterface {

	@Override
	public int[][] query(String q) throws Exception {
		switch (q) {
		case "1":
			return getContent("easy.txt");
		default:
			return getContent("difficult.txt");
		}
	}
}
