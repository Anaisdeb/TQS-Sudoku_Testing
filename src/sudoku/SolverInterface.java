package sudoku;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface SolverInterface {

	public void solve(Grid grid);

	private boolean solve(Grid grid, Optional<Grid.Cell> cell){
		return false;
	}

	private int[] generateRandomList() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(list);
		return list.stream().mapToInt(i -> i).toArray();
	}
}