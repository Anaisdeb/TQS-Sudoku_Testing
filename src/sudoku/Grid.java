package sudoku;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Grid {

  private final Cell[][] grid;
  private Cell[][] usrGrid;
  private Grid(Cell[][] grid) {
    this.grid = grid;
  }

  public static Grid of(int[][] grid) {
    verifyGrid(grid);

    Cell[][] cells = new Cell[9][9];
    List<List<Cell>> rows = new ArrayList<>();
    List<List<Cell>> columns = new ArrayList<>();
    List<List<Cell>> boxes = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      rows.add(new ArrayList<Cell>());
      columns.add(new ArrayList<Cell>());
      boxes.add(new ArrayList<Cell>());
    }

    Cell lastCell = null;
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        Cell cell = new Cell(grid[row][column]);
        cells[row][column] = cell;

        rows.get(row).add(cell);
        columns.get(column).add(cell);
        boxes.get((row / 3) * 3 + column / 3).add(cell);

        if (lastCell != null) {
          lastCell.setNextCell(cell);
        }

        lastCell = cell;
      }
    }

    for (int i = 0; i < 9; i++) {
      List<Cell> row = rows.get(i);
      for (Cell cell : row) {
        List<Cell> rowNeighbors = new ArrayList<>(row);
        rowNeighbors.remove(cell);

        cell.setRowNeighbors(rowNeighbors);
      }

      List<Cell> column = columns.get(i);
      for (Cell cell : column) {
        List<Cell> columnNeighbors = new ArrayList<>(column);
        columnNeighbors.remove(cell);

        cell.setColumnNeighbors(columnNeighbors);
      }

      List<Cell> box = boxes.get(i);
      for (Cell cell : box) {
        List<Cell> boxNeighbors = new ArrayList<>(box);
        boxNeighbors.remove(cell);

        cell.setBoxNeighbors(boxNeighbors);
      }
    }

    return new Grid(cells);
  }

  public static Grid emptyGrid() {
    int[][] emptyGrid = new int[9][9];
    return Grid.of(emptyGrid);
  }

  private static void verifyGrid(int[][] grid) {
    if(grid == null)
      throw new IllegalArgumentException("grid must not be null");
    
    if(grid.length != 9)
      throw new IllegalArgumentException("grid must have nine rows");

    for (int[] row : grid) {
      if (row.length != 9) {
        throw new IllegalArgumentException("grid must have nine columns");
      }

      for (int value : row) {
        if (value < 0 || value > 9) {
          throw new IllegalArgumentException("grid must contain values from 0-9");
        }
      }
    }
  }

  public void setUsrGrid(){usrGrid = this.grid;}

  public int getSize() {
    return grid.length;
  }

  public Cell getCell(int row, int column) {
    return grid[row][column];
  }

  public boolean isValidValueForCell(Cell cell, int value) {
    return isValidInRow(cell, value) && isValidInColumn(cell, value) && isValidInBox(cell, value);
  }

  private boolean isValidInRow(Cell cell, int value) {
    return !getRowValuesOf(cell).contains(value);
  }

  private boolean isValidInColumn(Cell cell, int value) {
    return !getColumnValuesOf(cell).contains(value);
  }

  private boolean isValidInBox(Cell cell, int value) {
    return !getBoxValuesOf(cell).contains(value);
  }

  private Collection<Integer> getRowValuesOf(Cell cell) {
    List<Integer> rowValues = new ArrayList<>();
    for (Cell neighbor : cell.getRowNeighbors()) rowValues.add(neighbor.getValue());
    return rowValues;
  }

  private Collection<Integer> getColumnValuesOf(Cell cell) {
    List<Integer> columnValues = new ArrayList<>();
    for (Cell neighbor : cell.getColumnNeighbors()) columnValues.add(neighbor.getValue());
    return columnValues;
  }

  private Collection<Integer> getBoxValuesOf(Cell cell) {
    List<Integer> boxValues = new ArrayList<>();
    for (Cell neighbor : cell.getBoxNeighbors()) boxValues.add(neighbor.getValue());
    return boxValues;
  }

  public Optional<Cell> getFirstEmptyCell() {
    Cell firstCell = grid[0][0];
    if (firstCell.isEmpty()) {
      return Optional.of(firstCell);
    }

    return getNextEmptyCellOf(firstCell);
  }

  public Optional<Cell> getNextEmptyCellOf(Cell cell) {
    Cell nextEmptyCell = null;

    while ((cell = cell.getNextCell()) != null) {
      if (!cell.isEmpty()) {
        continue;
      }

      nextEmptyCell = cell;
      break;
    }

    return Optional.ofNullable(nextEmptyCell);
  }

  public boolean add(int col, int row, int value) {
    if (this.grid[row][col].getValue() == 0 && value != 0) {
      if (isValidValueForCell(this.grid[row][col], value)) {
        this.grid[row][col].setValue(value);
        return true;
      }
    }
    return false;
  }

  public Cell remove(int col, int row) {
    Cell result;
    if (this.grid[row][col].getValue() != 0) {
      return null;
    }
    result = this.grid[row][col];
    this.grid[row][col].setValue(0);
    return result;
  }
  public boolean isSolved() {
    int counter = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (this.grid[i][j].getValue() != 0) {
          counter++;
          this.grid[i][j].setValue(this.usrGrid[i][j].getValue());
        }
        else {
          if (this.grid[i][j].getValue() != 0) {
            counter++;
          }
        }
      }
    }
    if (counter != 81) {
      return false;
    }
    for (int i = 0; i < 9; i++) {
      int[] array = new int[9];
      int value;
      for (int j = 0; j < 9; j++) {
        value = this.grid[i][j].getValue();
        array[value - 1] = 1;
      }
      for (int j = 0; j < 9; j++) {
        if (array[j] == 0) {
          return false;
        }
      }
    }
    for (int i = 0; i < 9; i++) {
      int[] array = new int[9];
      int value;
      for (int j = 0; j < 9; j++) {
        value = this.grid[i][j].getValue();
        array[value - 1] = 1;
      }
      for (int j = 0; j < 9; j++) {
        if (array[j] == 0) {
          return false;
        }
      }
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int[] array = new int[9];
        int value;
        for (int k = 0; k < 9; k++) {
          value = this.grid[i * 3 + k / 3][j * 3 + k % 3].getValue();
          array[value - 1] = 1;
        }
        for (int k = 0; k < 9; k++) {
          if (array[k] == 0) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override public String toString() {
    return StringConverter.toString(this);
  }

  public static class Cell {
    private int value;
    private Collection<Cell> rowNeighbors;
    private Collection<Cell> columnNeighbors;
    private Collection<Cell> boxNeighbors;
    private Cell nextCell;

    public Cell(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public boolean isEmpty() {
      return value == 0;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public Collection<Cell> getRowNeighbors() {
      return rowNeighbors;
    }

    public void setRowNeighbors(Collection<Cell> rowNeighbors) {
      this.rowNeighbors = rowNeighbors;
    }

    public Collection<Cell> getColumnNeighbors() {
      return columnNeighbors;
    }

    public void setColumnNeighbors(Collection<Cell> columnNeighbors) {
      this.columnNeighbors = columnNeighbors;
    }

    public Collection<Cell> getBoxNeighbors() {
      return boxNeighbors;
    }

    public void setBoxNeighbors(Collection<Cell> boxNeighbors) {
      this.boxNeighbors = boxNeighbors;
    }

    public Cell getNextCell() {
      return nextCell;
    }

    public void setNextCell(Cell nextCell) {
      this.nextCell = nextCell;
    }
  }

  private static class StringConverter {
    public static String toString(Grid grid) {
      StringBuilder builder = new StringBuilder();
      int size = grid.getSize();

      printTopBorder(builder);
      for (int row = 0; row < size; row++) {
        builder.append((row + 1)  + " ");
        printRowBorder(builder);
        for (int column = 0; column < size; column++) {
          printValue(builder, grid, row, column);
          printRightColumnBorder(builder, column + 1, size);
        }
        printRowBorder(builder);
        builder.append("\n");
        printBottomRowBorder(builder, row + 1, size);
      }
      printBottomBorder(builder);

      return builder.toString();
    }

    private static void printTopBorder(StringBuilder builder) {
      builder.append("  ║ A │ B │ C ║ D │ E │ F ║ G │ H │ I ║\n");
      builder.append("══╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n");
    }

    private static void printRowBorder(StringBuilder builder) {
      builder.append("║");
    }

    private static void printValue(StringBuilder builder, Grid grid, int row, int column) {
      int value = grid.getCell(row, column).getValue();
      String output = value != 0 ? String.valueOf(value) : " ";
      builder.append(" " + output + " ");
    }

    private static void printRightColumnBorder(StringBuilder builder, int column, int size) {
      if (column == size) {
        return;
      }

      if (column % 3 == 0) {
        builder.append("║");
      } else {
        builder.append("│");
      }
    }

    private static void printBottomRowBorder(StringBuilder builder, int row, int size) {
      if (row == size) {
        return;
      }

      if (row % 3 == 0) {
        builder.append("══╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n");
      } else {
        builder.append("──╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
      }
    }

    private static void printBottomBorder(StringBuilder builder) {
      builder.append("══╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝\n");
    }
  }
}
