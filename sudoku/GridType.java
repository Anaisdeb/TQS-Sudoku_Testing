package sudoku;

public enum GridType {
    ;
    private static final int rows = 9;
    private static final int columns = 9;
    private static final int boxWidth = 3;
    private static final int boxHeight = 3;
    private static final String [] validValues = new String[] {"1","2","3","4","5","6","7","8","9"};

    public static int getRows() {
        return rows;
    }

    public static int getColumns() {
        return columns;
    }

    public static int getBoxWidth() {
        return boxWidth;
    }

    public int getBoxHeight() {
        return boxHeight;
    }

    public static String [] getValidValues() {
        return validValues;
    }
}
