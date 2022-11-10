package sudoku;

import java.util.Scanner;

import sudoku.Grid.Cell;

public class Game {
	private static Grid usrSudoku;
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		//play();
		test();
		scanner.close();
	}

	private static void displayMenu() {
		System.out.println("\n1. Fill in a value.\n2. Undo last move.\n3. I give up, see the solution\n4. Exit");
	}

	private static void complexity() {
		System.out.println(
				"Enter the desired number of empty cells which will control the complexity of the grid: \nEnter 100 to exit game.");
		int complexity = scanner.nextInt();
		if (complexity > 0 && complexity < 81) {
			Generator generator = new Generator();
			usrSudoku = generator.generate(complexity);
		} else if (complexity == 100) {
			System.out.println("Goodbye!");
			System.exit(0);
		} else {
			System.out.println("Invalid complexity selection. Try again.");
			complexity();
		}
	}

	private static void play() {
		displayMenu();
	}
	
	private static void test() {
		// How to create Grid
		int[][] rawGrid = new int[][] { { 1, 6, 5, 7, 9, 4, 0, 3, 8 }, { 4, 0, 7, 0, 0, 2, 0, 5, 0 },
				{ 0, 0, 0, 6, 0, 2, 0, 0, 0 }, { 0, 0, 0, 6, 0, 2, 0, 0, 0 }, { 0, 0, 0, 6, 0, 2, 0, 0, 0 },
				{ 9, 3, 0, 0, 0, 6, 0, 0, 4 }, { 8, 1, 0, 4, 0, 5, 0, 0, 2 }, { 5, 7, 6, 2, 3, 9, 4, 0, 0 },
				{ 2, 0, 0, 6, 0, 1, 0, 7, 0 } };
		Grid grid = Grid.of(rawGrid);

		//Solver solver = new Solver();
		//solver.solve(grid);
		
		// How to use Grid
		int size = grid.getSize();
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				Cell cell = grid.getCell(row, column);
				// do something with cell like cell.getValue()
				System.out.println(cell.getValue());
			}
		}
	}
}