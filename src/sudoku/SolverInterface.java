package sudoku;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface SolverInterface {
	
	public default void solve(Grid grid) {
		boolean solvable = solve(grid, grid.getFirstEmptyCell());

		if (!solvable) {
			throw new IllegalStateException("The provided grid is not solvable.");
		}
	};
	
	public boolean solve(Grid grid, Optional<Grid.Cell> cell);
	
	public default int[] generateRandomList() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(list);
		return list.stream().mapToInt(i -> i).toArray();
	};
}