package test;
import org.junit.Test;

public class TestCase {
    @Test
    public void testGridAll(){
        GridTest gridTest = new GridTest();
        gridTest.verifyGridNullTest();
        gridTest.verifyGridRowTest();
        gridTest.verifyGridColumnTest();
        gridTest.verifyGridValueTest();
        gridTest.verifyGridValidTest();
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
        generatorTest.generateTestCoverage();
    }

    @Test
    public void testSolverAll(){
        SolverTest solverTest = new SolverTest();
        solverTest.solveTestTrue();
        solverTest.solveTestFalseGridFull();
        solverTest.solveTestFalseIllegalState();
    }
    
    @Test
    public void testAll() {
    	testGridAll();
    	testGeneratorAll();
    	testSolverAll();
    }
}
