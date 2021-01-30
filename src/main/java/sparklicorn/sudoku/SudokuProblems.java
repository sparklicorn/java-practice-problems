package sparklicorn.sudoku;

public class SudokuProblems {

    /**
     * Determines if the given row on the given Board is valid.
     * A row is valid if it contains the digits 0 through 9 with no digit
     * appearing more than once. 0 is excluded from this rule because it
     * represents an empty space.
     * A row with all empty spaces is considered valid.
     * @param board The Sudoku board to check.
     * @param row The row number in the Sudoku board.
     * @return True only if the row contains the digits 0 through 9 with no
     * digit appearing more than once (besides 0).
     */
    public static boolean isRowValid(Board board, int row) {
        // TODO
        return false;
    }

    /**
     * Determines if the given row on the given Board is full.
     * A row is full if it contains the digits 1 through 9 with no
     * digit appearing more than once.
     * @param board The Sudoku board to check.
     * @param row The row number in the Sudoku board.
     * @return True only if the row contains the digits 1 through 9 with no
     * digit appearing more than once.
     */
    public static boolean isRowFull(Board board, int row) {
        // TODO
        return false;
    }

    /**
     * Determines if the given column on the given Board is valid.
     * A column is valid if it contains the digits 0 through 9 with no digit
     * appearing more than once. 0 is excluded from this rule because it
     * represents an empty space.
     * A column with all empty spaces is considered valid.
     * @param board The Sudoku board to check.
     * @param col The column number in the Sudoku board to check.
     * @return True only if the column contains the digits 0 through 9 with no
     * digit appearing more than once (besides 0).
     */
    public static boolean isColValid(Board board, int col) {
        // TODO
        return false;
    }

    /**
     * Determines if the given column on the given Board is full.
     * A column is full if it contains the digits 1 through 9 with no
     * digit appearing more than once.
     * @param board The Sudoku board to check.
     * @param col The column number in the Sudoku board.
     * @return True only if the column contains the digits 1 through 9 with no
     * digit appearing more than once.
     */
    public static boolean isColFull(Board board, int col) {
        // TODO
        return false;
    }

    /**
     * Determines if the given region on the given Board is valid.
     * A region is valid if it contains the digits 0 through 9 with no digit
     * appearing more than once. 0 is excluded from this rule because it
     * represents an empty space.
     * A region with all empty spaces is considered valid.
     * @param board The Sudoku board to check.
     * @param regionRow The region row number in the Sudoku board. [0, 2]
     * @param regionCol The region col number in the Sudoku board. [0, 2]
     * @return True only if the region contains the digits 0 through 9 with no
     * digit appearing more than once (besides 0).
     */
    public static boolean isRegionValid(Board board, int regionRow, int regionCol) {
        // TODO
        return false;
    }

    /**
     * Determines if the given region on the given Board is full.
     * A region is full if it contains the digits 1 through 9 with no
     * digit appearing more than once.
     * @param board The Sudoku board to check.
     * @param regionRow The region row number in the Sudoku board. [0, 2]
     * @param regionCol The region col number in the Sudoku board. [0, 2]
     * @return True only if the region contains the digits 1 through 9 with no
     * digit appearing more than once.
     */
    public static boolean isRegionFull(Board board, int regionRow, int regionCol) {
        // TODO
        return false;
    }

    /**
     * Determines if the given Board is valid.
     * A board is valid if all rows, columns, and regions are valid.
     * Because an empty row, column, or region is considered valid,
     * the entire board is considered valid by extension if it is completely empty.
     * @param board The Sudoku board to check.
     * @return True only if all rows, columns, and regions are valid.
     */
    public static boolean isBoardValid(Board board) {
        // TODO
        return false;
    }

    /**
     * Determines if the given Board is full.
     * A board is full if all rows, columns, and regions are full.
     * @param board The Sudoku board to check.
     * @return True only if all rows, columns, and regions are full.
     */
    public static boolean isBoardFull(Board board) {
        // TODO
        return false;
    }

    /**
     * Determines if the given Board is complete.
     * A board is complete if it is both full and valid.
     * @param board The Sudoku board to check.
     * @return True only if the board both full and valid.
     */
    public static boolean isBoardComplete(Board board) {
        // TODO
        return false;
    }
}
