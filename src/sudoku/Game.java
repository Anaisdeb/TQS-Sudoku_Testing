package sudoku;

import java.util.Scanner;

public class Game {
	private static Scanner scanner;

	public static void main(String[] args) {
		Play play = new Play();
		play.play(0);
	}

}