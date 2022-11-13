package sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DB implements DBInterface {

	@Override
	public int[][] query(String q) {
		switch (q) {
		case "1":
			return getContent("easy.txt");
		case "2":
			return getContent("difficult.txt");
		default:
			System.out.println("Invalid selection.");
		}
		return null;
	}

	public int[][] getContent(String fileName) {
		int[][] grid = new int[9][9];
		String ligne = "";
		Random random = new Random();
		// Choose a random sudoku among the DB
		int nbLigne = random.nextInt(2);
		int i = 0;
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			
			ligne = br.readLine();
			while (ligne != null && i != nbLigne) {
				ligne = br.readLine();
				i++;
			}
			ligne = ligne.trim();
			Scanner sc2 = new Scanner(ligne);
			List<Integer> list = new ArrayList<Integer>();
			while (sc2.hasNextInt()) {
				list.add(sc2.nextInt());
			}
			int j = 0;
			for (int row = 0; row < 9; row++) {
				for (int column = 0; column < 9; column++) {
					grid[row][column] = list.get(j);
					j++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return grid;
	}
}
