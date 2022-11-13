package sudoku;

import java.util.Optional;

public class Solver implements SolverInterface{
	private static final int EMPTY = 0;

	private final int[] values;

	public Solver() {
		this.values = generateRandomList();
	}
	
	@Override
	public boolean solve(Grid grid, Optional<Grid.Cell> cell) {
		if (!cell.isPresent()) {
			return true;
		}

		for (int value : values) {
			if (grid.isValidValueForCell(cell.get(), value)) {
				cell.get().setValue(value);
				if (solve(grid, grid.getNextEmptyCellOf(cell.get())))
					return true;
				cell.get().setValue(EMPTY);
			}
		}

		return false;
	}
}