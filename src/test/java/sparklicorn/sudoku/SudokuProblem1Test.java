package sparklicorn.sudoku;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import org.junit.BeforeClass;
import org.junit.Test;

public class SudokuProblem1Test {

    private static class BoardFixture {
        static final String INVALID_SOLUTION = "NO SOLUTION";

        String boardString;
        String solutionString;

        int numClues;
        boolean isFull;
        boolean isValid;
        boolean isComplete;

        List<Integer> validRows;
        List<Integer> validCols;
        List<Integer> validRegions;
        List<Integer> fullRows;
        List<Integer> fullCols;
        List<Integer> fullRegions;

        transient Board board;

        static List<BoardFixture> loadFromFile(String filename) throws IOException {
            List<BoardFixture> fixtures = new ArrayList<>();

            Scanner scanner = new Scanner(new File(filename));
            Gson gson = new Gson();
            while (scanner.hasNextLine()) {
                BoardFixture fixture = gson.fromJson(scanner.nextLine(), BoardFixture.class);
                fixture.getBoard();
                fixtures.add(fixture);
            }

            return fixtures;
        }

        Board getBoard() {
            if (this.board == null) {
                this.board = new Board(this.boardString);
            }
            return this.board;
        }

        String getRowAsString(int row) {
            StringBuilder strb = new StringBuilder();
            for (int col = 0; col < Board.NUM_COLS; col++) {
                strb.append(board.getValue(row, col));
            }
            return strb.toString();
        }

        String getColumnAsString(int col) {
            StringBuilder strb = new StringBuilder();
            for (int row = 0; row < Board.NUM_ROWS; row++) {
                strb.append(board.getValue(row, col));
            }
            return strb.toString();
        }

        String getRegionAsString(int regionRow, int regionCol) {
            StringBuilder strb = new StringBuilder();
            for (int row = regionRow * Board.NUM_REGION_ROWS; row < (regionRow + 1) * Board.NUM_REGION_ROWS; row++) {
                for (int col = regionCol * Board.NUM_REGION_COLS; col < (regionCol + 1) * Board.NUM_REGION_COLS; col++) {
                    strb.append(board.getValue(row, col));
                }
            }
            return strb.toString();
        }
    }

    private static List<BoardFixture> boardFixtures;
    private static final String boardFixturesFilePath = "src/test/java/sparklicorn/fixtures/sudoku-board-fixtures.txt";

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.print("Loading test fixtures... ");
        boardFixtures = BoardFixture.loadFromFile(boardFixturesFilePath);
        if (boardFixtures.size() == 0) {
            throw new Exception("Test fixtures failed to load");
        }
        System.out.printf("Done. (%d fixtures loaded)%n", boardFixtures.size());
    }

    @Test
    public void isRowValid() {
        for(BoardFixture fixture : boardFixtures) {
            for (int row = 0; row < Board.NUM_ROWS; row++) {
                assertEquals(
                    String.format(
                        "Row [%s] of board %n%s%n%s%n",
                        fixture.getRowAsString(row),
                        fixture.board.getSimplifiedString(),
                        fixture.board.toString()
                    ),
                    fixture.validRows.contains(row),
                    SudokuProblems.isRowValid(fixture.board, row)
                );
            }
        }
    }

    @Test
    public void isColValid() {
        for(BoardFixture fixture : boardFixtures) {
            for (int col = 0; col < Board.NUM_COLS; col++) {
                assertEquals(
                    String.format(
                        "Col [%s] of board %n%s%n%s%n",
                        fixture.getColumnAsString(col),
                        fixture.board.getSimplifiedString(),
                        fixture.board.toString()
                    ),
                    fixture.validCols.contains(col),
                    SudokuProblems.isColValid(fixture.board, col)
                );
            }
        }
    }

    @Test
    public void isRegionValid() {
        for(BoardFixture fixture : boardFixtures) {
            for (int regRow = 0; regRow < Board.NUM_REGION_ROWS; regRow++) {
                for (int regCol = 0; regCol < Board.NUM_REGION_COLS; regCol++) {
                    assertEquals(
                        String.format(
                            "Region (%d, %d) [%s] of board %n%s%n%s%n",
                            regRow,
                            regCol,
                            fixture.getRegionAsString(regRow, regCol),
                            fixture.board.getSimplifiedString(),
                            fixture.board.toString()
                        ),
                        fixture.validRegions.contains(regRow * 3 + regCol),
                        SudokuProblems.isRegionValid(fixture.board, regRow, regCol)
                    );
                }
            }
        }
    }

    @Test
    public void isRowFull() {
        for(BoardFixture fixture : boardFixtures) {
            for (int row = 0; row < Board.NUM_ROWS; row++) {
                assertEquals(
                    String.format(
                        "Row [%s] of board %n%s%n%s%n",
                        fixture.getRowAsString(row),
                        fixture.board.getSimplifiedString(),
                        fixture.board.toString()
                    ),
                    fixture.fullRows.contains(row),
                    SudokuProblems.isRowFull(fixture.board, row)
                );
            }
        }
    }

    @Test
    public void isColFull() {
        for(BoardFixture fixture : boardFixtures) {
            for (int col = 0; col < Board.NUM_COLS; col++) {
                assertEquals(
                    String.format(
                        "Col [%s] of board %n%s%n%s%n",
                        fixture.getColumnAsString(col),
                        fixture.board.getSimplifiedString(),
                        fixture.board.toString()
                    ),
                    fixture.fullCols.contains(col),
                    SudokuProblems.isColFull(fixture.board, col)
                );
            }
        }
    }

    @Test
    public void isRegionFull() {
        for(BoardFixture fixture : boardFixtures) {
            for (int regRow = 0; regRow < Board.NUM_REGION_ROWS; regRow++) {
                for (int regCol = 0; regCol < Board.NUM_REGION_COLS; regCol++) {
                    assertEquals(
                        String.format(
                            "Region (%d, %d) [%s] of board %n%s%n%s%n",
                            regRow,
                            regCol,
                            fixture.getRegionAsString(regRow, regCol),
                            fixture.board.getSimplifiedString(),
                            fixture.board.toString()
                        ),
                        fixture.fullRegions.contains(regRow * 3 + regCol),
                        SudokuProblems.isRegionFull(fixture.board, regRow, regCol)
                    );
                }
            }
        }
    }

    @Test
    public void isBoardValid() {
        for(BoardFixture fixture : boardFixtures) {
            assertEquals(
                String.format(
                    "Board %n%s%n%s%n",
                    fixture.board.getSimplifiedString(),
                    fixture.board.toString()
                ),
                fixture.isValid,
                SudokuProblems.isBoardValid(fixture.board)
            );
        }
    }

    @Test
    public void isBoardFull() {
        for(BoardFixture fixture : boardFixtures) {
            assertEquals(
                String.format(
                    "Board %n%s%n%s%n",
                    fixture.board.getSimplifiedString(),
                    fixture.board.toString()
                ),
                fixture.isFull,
                SudokuProblems.isBoardFull(fixture.board)
            );
        }
    }

    @Test
    public void isBoardComplete() {
        for(BoardFixture fixture : boardFixtures) {
            assertEquals(
                String.format(
                    "Board %n%s%n%s%n",
                    fixture.board.getSimplifiedString(),
                    fixture.board.toString()
                ),
                fixture.isComplete,
                SudokuProblems.isBoardComplete(fixture.board)
            );
        }
    }
}
