package sudoku;

import java.util.Random;

public interface GeneratorInterface {
	
	/**
	 * Returns the instance of the generator's solver
	 * @return the instance of the generator's solver
	 */
	public SolverInterface getSolver();
	
	/**
	 * Returns the instance of the generator's database
	 * @return the instance of the generator's database
	 */
	public DBInterface getDb();
	
	/**
	 * Generates a sudoku grid containing the requested number of empty cells.
	 * @param numberOfEmptyCells
	 * @return
	 */
	public default Grid generate(int numberOfEmptyCells) {
		Grid grid = generate();
	    eraseCells(grid, numberOfEmptyCells);
	    return grid;
	};
	
	/**
	 * Randomly chooses the cells to be erased in a grid according to the number.
	 * @param grid
	 * @param numberOfEmptyCells
	 */
	public default void eraseCells(Grid grid, int numberOfEmptyCells) {
		Random random = new Random();
		for (int i = 0; i < numberOfEmptyCells; i++) {
			int randomRow = random.nextInt(9);
			int randomColumn = random.nextInt(9);

			Grid.Cell cell = grid.getCell(randomRow, randomColumn);
			if (!cell.isEmpty()) {
				cell.setValue(0);
			} else {
				i--;
			}
		}
	}
	
	/**
	 * Generates a filled sudoku grid with the solver class.
	 * @return a filled sudoku grid
	 */
	public Grid generate();
}