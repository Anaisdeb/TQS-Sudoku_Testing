package test;

import org.junit.Test;
import sudoku.Generator;
import sudoku.Grid;
import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    public void generateTest(){
        Generator gen = new Generator(new MockSolver());
        Grid testgrid = Grid.emptyGrid();
        testgrid = gen.generate(1);
        int blank = 0;
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                int value = testgrid.getCell(i, j).getValue();
                if(value == 0){
                    blank++;
                }
            }
        }
        assertEquals(blank, 1);
    }

    @Test
    public void generateTestCoverage(){
        Generator gen = new Generator(new MockSolver());
        Grid testgrid = Grid.emptyGrid();
        testgrid = gen.generate(80);
        int blank = 0;
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                int value = testgrid.getCell(i, j).getValue();
                if(value == 0){
                    blank++;
                }
            }
        }
        assertEquals(blank, 80);
    }


}
