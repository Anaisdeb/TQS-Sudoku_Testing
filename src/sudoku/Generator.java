package sudoku;

import java.util.Random;

public class Generator {
  private SolverInterface solver;

  public Generator(SolverInterface solver1) {
    this.solver = solver1;
  }

  public Grid generate(int numberOfEmptyCells) {
    Grid grid = generate();

    eraseCells(grid, numberOfEmptyCells);

    return grid;
  }

  private void eraseCells(Grid grid, int numberOfEmptyCells) {
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

  private Grid generate() {
    Grid grid = Grid.emptyGrid();

    solver.solve(grid);

    return grid;
  }
}