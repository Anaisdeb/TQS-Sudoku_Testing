package sudoku;

import java.util.Scanner;

public class Play {
    private static Grid usrSudoku;
    private static Scanner scanner;
    private static void startplay(int exit) {
        System.out.println("\n1. Play\n2. Exit game");
        int usrChoice = scanner.nextInt();
        switch (usrChoice) {
            case 1:
                complexity(exit);
                break;
            case 2:
                System.out.println("Goodbye!");
                if(exit == 0) {
                    System.exit(0);
                } else {
                    return;
                }
                break;
            default:
                System.out.println("Invalid selection, try again.");
                startplay(exit);
        }
    }

    private static boolean cellParser() {
        System.out.println("\nType in the location to fill in");
        String location = scanner.next().toUpperCase();
        if (location.matches("[A-I][1-9]")) {
            int col = ((int) location.charAt(0))-65;
            int row = ((int) location.charAt(1))-49;
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

    private static void complexity(int exit) {
        System.out.println(
                "Enter the desired number of empty cells which will control the complexity of the grid: \nEnter 100 to exit game.");
        int complexity = scanner.nextInt();
        if (complexity > 0 && complexity < 81) {
            Generator generator = new Generator(new Solver());
            usrSudoku = generator.generate(complexity);
            usrSudoku.setInitialGrid(Grid.of(usrSudoku.tab()));
            System.out.println(usrSudoku.toString());
        } else if (complexity == 100) {
            System.out.println("Goodbye!");
            if(exit == 0) {
                System.exit(0);
            } else {
                return;
            }
        } else {
            System.out.println("Invalid complexity selection. Try again.");
            complexity(exit);
        }
    }

    public static void play(int exit) {
        scanner = new Scanner(System.in);
        boolean endGame;
        while (true) {
            startplay(exit);
            endGame = false;
            while (!endGame) {
                System.out.println("\n1. Fill in a value\n2. I give up, see the solution\n3. Exit the session");
                int usrChoice = scanner.nextInt();
                switch (usrChoice) {
                    case 1:
                        cellParser();
                        if (!usrSudoku.getFirstEmptyCell().isPresent()) {
                            System.out.println("\nYou're a winner!");
                            endGame = true;
                        }
                        break;
                    case 2:
                        Solver solver = new Solver();
                        solver.solve(usrSudoku);
                        System.out.println(usrSudoku.toString());
                        endGame = true;
                        break;
                    case 3:
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
