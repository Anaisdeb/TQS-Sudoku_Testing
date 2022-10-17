# TQS-Sudoku
Create a Sudoku generator and solver for Java, then test it with JUnit Testing in Eclipse

This library for Java and Android provides the basis for the project : [Sudoku](https://github.com/a11n/sudoku).

To keep in mind: we are using 0 to represent an element of the Sudoku grid that the player has not yet filled in.

## MVC software architectural pattern : 
  * *Model* (Data)
    * Ranking with time and name of the player
    * Saving of the Sudoku board if the user closes the game in progress
    * TXT file or MongoDB
  * *Controller* (Logic)
    * Generate the sudoku and check the player's inputs
  * *View* (Display) 
    * TXT file
    
## Test-Driven Development - Requirements for the 3 Sudoku classes: 
* *Sudoku Checker* – determines whether its argument is a valid Sudoku grid. 
1.	each number in the range 1..9 occurs only once in each row
2.	each number in the range 1..9 occurs only once in each column
3.	each number the range 1..9 occurs only once in each of the nine 3x3 sub-grids, or “boxes”, that make up the board
* *Sudoku Generator* – creates Sudoku grids in different levels. 
1.	is a 9x9 list of lists
2.	contains, in each of its 81 elements, a number in the range 0..9
* *Sudoku Solver* - solves any Sudoku grid.

## Homework for the 18th of October: 
  * Study this [git repository](https://github.com/a11n/sudoku)
  * List the items to be modified from this library
  * Think about the graphical interface: txt or other?
  * Think about the non-relational database: txt or MongoDB ?
