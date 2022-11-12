package sudoku;

import java.util.Scanner;

public class Game {
	private static Scanner scanner;

	public static void main(String[] args) {
		Play play = new Play();
		SolverInterface solver = new Solver();
		GeneratorInterface gen = new Generator(solver);
		play.play(0, gen);
	}

}