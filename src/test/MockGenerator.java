package test;

import sudoku.GeneratorInterface;
import sudoku.Grid;
import sudoku.SolverInterface;

public class MockGenerator implements GeneratorInterface {
	private SolverInterface solver;
	
	public MockGenerator(SolverInterface solver) {
	    this.solver = solver;
	  }
	
	@Override
	public void eraseCells(Grid grid, int numberOfEmptyCells) {
		for (int i = 0; i < numberOfEmptyCells; i++) {
			Grid.Cell cell = grid.getCell(i, i);
			if (!cell.isEmpty()) {
				cell.setValue(0);
			} else {
				i--;
			}
		}
	}
	
	@Override
	public Grid generate() {
	    Grid grid = Grid.emptyGrid();
	    solver.solve(grid);
	    return grid;
	}
}
