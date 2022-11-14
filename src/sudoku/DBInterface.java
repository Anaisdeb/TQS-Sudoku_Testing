package sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public interface DBInterface {
	public int[][] query(String q) throws Exception;
	
	public default int[][] getContent(String fileName) throws Exception {
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
		} catch (Exception e) {
			throw new IllegalArgumentException("Incorrect database file.");
		}
		return grid;
	}
}
