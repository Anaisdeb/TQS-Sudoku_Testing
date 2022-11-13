package sudoku;

import java.util.Random;

public interface GeneratorInterface {

	public default Grid generate(int numberOfEmptyCells) {
		Grid grid = generate();
	    eraseCells(grid, numberOfEmptyCells);
	    return grid;
	};

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

	public Grid generate();
}