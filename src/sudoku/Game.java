package sudoku;

import java.util.ArrayList;
import java.util.Scanner;

import sudoku.Grid.Cell;

public class Game {
	private static Grid usrSudoku;
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		play();
		//test();
		scanner.close();
	}

	private static void displayMenu() {
		System.out.println("\n1. Fill in a value.\n2. I give up, see the solution\n3. Exit");
	}

	private static int startplay() {
		Scanner scanner = new Scanner(System.in);
		int result = 1;
		System.out.println("\n1. Play...\n2. Exit game...");
		String usrChoice = scanner.next().toLowerCase();
		if (usrChoice.equals("1")) {
			complexity();
		}
		else if (usrChoice.equals("2")) {
			System.out.println("Exiting the game......");
			result = 0;
		}
		else {
			System.out.println("Invalid difficulty selection, try again...");
			result = -1;
		}
		return result;
	}
	private static boolean parseAdd(String str) {
		Scanner scanner = new Scanner(System.in);
		if (str.matches("[A-I][1-9]")) {
			int colASCII = (int)str.charAt(0);
			int rowASCII = (int)str.charAt(1);
			System.out.println("\nNow type in the value...");
			int usrValue = scanner.nextInt();
			if (usrValue <= 9 && usrValue >= 1) {
				if (usrSudoku.add(colASCII - 65, rowASCII - 49, usrValue)) {
					System.out.println("Successfully added " + usrValue + " to " + str + "\n");
					System.out.println(usrSudoku.toString());
					return true;
				}
			}
		}
		else {
			return false;
		}
		return false;
	}

	private static void complexity() {
		System.out.println(
				"Enter the desired number of empty cells which will control the complexity of the grid: \nEnter 100 to exit game.");
		int complexity = scanner.nextInt();
		if (complexity > 0 && complexity < 81) {
			Generator generator = new Generator();
			usrSudoku = generator.generate(complexity);
			usrSudoku.setUsrGrid();
			System.out.println(usrSudoku.toString());
		} else if (complexity == 100) {
			System.out.println("Goodbye!");
			System.exit(0);
		} else {
			System.out.println("Invalid complexity selection. Try again.");
			complexity();
		}
	}

	private static void play() {
		Scanner scanner = new Scanner(System.in);
		boolean endGame;
		int diffReturn;
		String location = "";
		boolean parseAddReturn;
		ArrayList<String> undoList = new ArrayList<String>();
		while ((diffReturn = startplay()) != 0) {
			endGame = false;
			if (diffReturn == 1) {
				while (!endGame) {
					displayMenu();
					String usrChoice = scanner.next();
					if (usrChoice.equals("1")) {
						System.out.println("\nType in the location to fill in...");
						location = scanner.next().toUpperCase();
						parseAddReturn = parseAdd(location);
						boolean solvedStatus = usrSudoku.isSolved();
						if (solvedStatus) {
							System.out.println("\nYou Won!");
							endGame = true;
						}
						if (!parseAddReturn) {
							System.out.println("Can't fill this value in this place, try again...");
							System.out.println(usrSudoku.toString());
						}
						else {
							undoList.add(location);
						}
					}
					else if (usrChoice.equals("2")) {
						Solver solver = new Solver();
						solver.solve(usrSudoku);
						System.out.println(usrSudoku.toString());
						endGame = true;
					}
					else if (usrChoice.equals("3")) {
						System.out.println("Quitting to difficulty selection...");
						endGame = true;
					}
					else {
						System.out.println("Invalid input, try again...");
						endGame = false;
					}
				}
			}
		}
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
		String gridstring =  grid.toString();
		System.out.println(gridstring);
		/*for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				Cell cell = grid.getCell(row, column);
				// do something with cell like cell.getValue()
				System.out.println(cell.getValue());
			}
		}*/
	}
}