package sudoku;

import java.util.Random;

public interface GeneratorInterface {

  public Grid generate(int numberOfEmptyCells);

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
    return null;
  }
}