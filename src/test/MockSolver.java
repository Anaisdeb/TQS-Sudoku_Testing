package test;

import java.util.Optional;

import sudoku.Grid;
import sudoku.SolverInterface;

public class MockSolver implements SolverInterface {
	private static final int EMPTY = 0;

	private final int[] values;

	public MockSolver() {
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
    
    @Override
    public int[] generateRandomList() {
		int [] list ={1,2,3,4,5,6,7,8,9};
		return list;
	}
}
