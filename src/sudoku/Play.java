package sudoku;

import java.util.Scanner;

public class Play {
	private static Grid usrSudoku;
	private static Scanner scanner;

	private static boolean startplay(int exit, GeneratorInterface gen) {
		System.out.println("\n1. Play\n2. Exit game");
		boolean game = true;
		String usrChoice = scanner.next();
		switch (usrChoice) {
		case "1":
			game = complexity(exit, gen);
			break;
		case "2":
			System.out.println("Goodbye!");
			return false;
		default:
			System.out.println("Invalid selection, try again.");
			game = startplay(exit, gen);
		}
		return game;
	}

	private static boolean cellParser() {
		System.out.println("\nType in the location to fill in");
		String location = scanner.next().toUpperCase();
		if (location.matches("[A-I][1-9]")) {
			int col = ((int) location.charAt(0)) - 65;
			int row = ((int) location.charAt(1)) - 49;
			System.out.println("\nNow type in the value");
			int usrValue = scanner.nextInt();
			if (usrValue <= 9 && usrValue >= 1) {
				if (usrSudoku.add(col, row, usrValue)) {
					System.out.println("Successfully added " + usrValue + " to " + location + "\n");
					System.out.println(usrSudoku.toString());
					return true;
				}
			}
		}
		System.out.println("Can't fill this value in this place, try again");
		System.out.println(usrSudoku.toString());
		return false;
	}

	private static boolean complexity(int exit, GeneratorInterface gen) {
		System.out.println(
				"Enter the desired number of empty cells which will control the complexity of the grid: \nEnter 100 to exit game.");
		String comp = scanner.next();
		int complexity = 0;
		boolean game = true;
		if (comp != null && comp.matches("[0-9]+")) {
			complexity = Integer.parseInt(comp);
		} else {
			complexity = -1;
		}
		if (complexity > 0 && complexity < 81) {
			GeneratorInterface generator = gen;
			usrSudoku = generator.generate(complexity);
			usrSudoku.setInitialGrid(Grid.of(usrSudoku.tab()));
			System.out.println(usrSudoku.toString());
		} else if (complexity == 100) {
			System.out.println("Goodbye!");
			game = false;
			return false;
		} else {
			System.out.println("Invalid complexity selection. Try again.");
			game = complexity(exit, gen);
		}
		return game;
	}

	public static void play(int exit, GeneratorInterface gen) {
		scanner = new Scanner(System.in);
		boolean endGame;
		boolean game = true;
		while (game) {
			game = startplay(exit, gen);
			if (game) {
				endGame = false;
				while (!endGame) {
					System.out.println("\n1. Fill in a value\n2. I give up, see the solution\n3. Exit the session");
					String usrChoice = scanner.next();
					switch (usrChoice) {
					case "1":
						cellParser();
						if (!usrSudoku.getFirstEmptyCell().isPresent()) {
							System.out.println("\nYou're a winner!");
							endGame = true;
						}
						break;
					case "2":
						Solver solver = new Solver();
						solver.solve(usrSudoku);
						System.out.println(usrSudoku.toString());
						endGame = true;
						break;
					case "3":
						System.out.println("Quit to choose the difficulty");
						endGame = true;
						break;
					default:
						System.out.println("Invalid input, try again");
					}
				}
			}
		}
	}
}
