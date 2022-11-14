package sudoku;

public class Generator implements GeneratorInterface {
	private SolverInterface solver;
	private DBInterface db;

	@Override
	public SolverInterface getSolver() {
		return solver;
	}
	
	@Override
	public DBInterface getDb() {
		return db;
	}

	public Generator(SolverInterface solver, DBInterface db) {
		this.solver = solver;
		this.db = db;
	}

	@Override
	public Grid generate() {
		Grid grid = Grid.emptyGrid();
		solver.solve(grid);
		return grid;
	}
}