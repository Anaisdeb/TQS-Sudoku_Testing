package test;
import org.junit.Test;

import java.io.IOException;

public class TestCase {
    @Test
    public void testGridAll(){
        GridTest gridTest = new GridTest();
        gridTest.verifyGridNullTest();
        gridTest.verifyGridRowTest();
        gridTest.verifyGridColumnTest();
        gridTest.verifyGridValueTest();
        gridTest.verifyGridValidTest();
        gridTest.verifyGridTest();
        gridTest.ofTest();
        gridTest.emptyGridTest();
        gridTest.isValidValueForCellTest();
        gridTest.tabTest();
        gridTest.getFirstEmptyCellTest();
        gridTest.getNextEmptyCellOfTest();
        gridTest.addTest();
        gridTest.StringConverterTest();
        gridTest.getInitialGridTest();
        gridTest.setInitialGridTest();
        gridTest.getSizeTest();
        gridTest.getCellTest();
        gridTest.setCellValueTest();
        gridTest.getValueTest();
        gridTest.setValueTest();
        gridTest.isEmptyTest();
        gridTest.getRowNeighborsTest();
        gridTest.getColumnNeighborsTest();
        gridTest.setColumnNeighborsTest();
        gridTest.setRowNeighborsTest();
        gridTest.getNextCellTest();
        gridTest.setNextCellTest();
    }

    @Test
    public void testGeneratorAll(){
        GeneratorTest generatorTest = new GeneratorTest();
        generatorTest.generateTest();
        generatorTest.eraseCellsTest();
    }

    @Test
    public void testSolverAll(){
        SolverTest solverTest = new SolverTest();
        solverTest.solveTestTrue();
        solverTest.solveTestFalseGridFull();
        solverTest.solveTestFalseIllegalState();
        solverTest.solveTest();
    }
/*
    @Test
    public void testPlayAll() throws IOException {
        PlayTest playTest = new PlayTest();
        playTest.playSolveTest();
        playTest.playExitTest();
        playTest.playComplexityTest();
        playTest.playCellParserTest();
        playTest.playCompleteTest();
    }
    */
    @Test
    public void testAll() throws IOException {
    	testGridAll();
    	testGeneratorAll();
    	testSolverAll();
        //testPlayAll();
    }
}
