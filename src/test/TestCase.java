package test;
import org.junit.Test;

public class TestCase {
    @Test
    void testGridAll(){
        GridTest gridTest = new GridTest();
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
    void testGeneratorAll(){
        GeneratorTest generatorTest = new GeneratorTest();

    }

    @Test
    void testSolverAll(){
        SolverTest solverTest = new SolverTest();
        solverTest.solveTestTrue();
        solverTest.solveTestFalseGridFull();
        solverTest.solveTestFalseIllegalState();
    }
}
