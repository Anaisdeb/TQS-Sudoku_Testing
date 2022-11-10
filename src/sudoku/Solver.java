package sudoku;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Solver {
	private static final int EMPTY = 0;

	private final int[] values;

	public Solver() {
		this.values = generateRandomList();
	}

	public void solve(Grid grid) {
		boolean solvable = solve(grid, grid.getFirstEmptyCell());

		if (!solvable) {
			throw new IllegalStateException("The provided grid is not solvable.");
		}
	}

	private boolean solve(Grid grid, Optional<Grid.Cell> cell) {
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

	private int[] generateRandomList() {
		List<Integer> list = Arrays.asList(EMPTY, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(list);
		return list.stream().mapToInt(i -> i).toArray();
	}
}