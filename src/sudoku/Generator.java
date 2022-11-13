package sudoku;

public class Generator implements GeneratorInterface{
  private SolverInterface solver;

  public Generator(SolverInterface solver) {
    this.solver = solver;
  }
  
  @Override
  public Grid generate() {
    Grid grid = Grid.emptyGrid();
    solver.solve(grid);
    return grid;
  }
}