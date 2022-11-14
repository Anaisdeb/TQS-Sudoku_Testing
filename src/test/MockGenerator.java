package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sudoku.DBInterface;
import sudoku.GeneratorInterface;
import sudoku.Grid;
import sudoku.SolverInterface;

/**
 * Override the random function eraseCells() which randomly chooses the cells to be erased.
 */
public class MockGenerator implements GeneratorInterface {
	private SolverInterface solver;
	private DBInterface db;
	private Map<Integer, List<Integer>> eraseCellsOrder;

	public MockGenerator(SolverInterface solver, DBInterface db) {
		this.solver = solver;
		this.db = db;
		
		// Defines the order of deletion of the cells 
		// From left to right, in ascending order
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int i = 0;
		for (int numRow = 0; numRow < 9; numRow++) {
			for (int numCol = 0; numCol < 9; numCol++) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(numRow);
				list.add(numCol);
				map.put(i, list);
				i++;
			}
		}
		this.eraseCellsOrder = map;
	}

	@Override
	public void eraseCells(Grid grid, int numberOfEmptyCells) {
		int row;
		int col;
		for (int i = 0; i < numberOfEmptyCells; i++) {
			row = eraseCellsOrder.get(i).get(0);
			col = eraseCellsOrder.get(i).get(1);
			Grid.Cell cell = grid.getCell(row, col);
			cell.setValue(0);
		}
	}

	@Override
	public Grid generate() {
		Grid grid = Grid.emptyGrid();
		solver.solve(grid);
		return grid;
	}

	@Override
	public SolverInterface getSolver() {
		return solver;
	}

	@Override
	public DBInterface getDb() {
		return db;
	}
}
