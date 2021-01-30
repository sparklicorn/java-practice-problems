package sparklicorn.sudoku;

public class Board {

    public static final int NUM_ROWS = 9;
    public static final int NUM_COLS = 9;
    public static final int NUM_REGIONS = 9;
    public static final int NUM_REGION_ROWS = 3;
    public static final int NUM_REGION_COLS = 3;
    public static final int NUM_CELLS = NUM_ROWS * NUM_COLS;

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;

    private static final String RANGE_VALIDATION_ERROR_MSG = "%s (%d) must be in range [%d, %d)";

    private static final String EMPTY_BOARD_STRING = "---------";

    private static void validatePosition(int row, int col) {
        if (row < 0 || row >= NUM_ROWS) {
            throw new IllegalArgumentException(
                String.format(RANGE_VALIDATION_ERROR_MSG, "row", row, 0, NUM_ROWS)
            );
        }

        if (col < 0 || col >= NUM_COLS) {
            throw new IllegalArgumentException(
                String.format(RANGE_VALIDATION_ERROR_MSG, "col", col, 0, NUM_COLS)
            );
        }
    }

    private static void validateBoardValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(
                String.format(RANGE_VALIDATION_ERROR_MSG, "value", value, MIN_VALUE, MAX_VALUE+1)
            );
        }
    }

    /** **************************** */

    private int[][] values;

    public Board() {
        this(EMPTY_BOARD_STRING);
    }

    public Board(String str) {
        if (str == null) {
			throw new NullPointerException("Given Board string cannot be null.");
        }

        this.values = new int[NUM_ROWS][];
        for (int i = 0; i < NUM_ROWS; i++) {
            this.values[i] = new int[NUM_COLS];
        }

		//Empty row shorthand.
		str = str.replaceAll("-", "000000000");

		if (str.length() > NUM_CELLS) {
			str = str.substring(0, NUM_CELLS);
		}

		while (str.length() < NUM_CELLS) {
			str += "0";
		}

		//Non-conforming characters to ZERO / empty space.
		str = str.replaceAll("[^1-9]", "0");

		for (int i = 0; i < NUM_CELLS; i++) {
            int row = i / NUM_ROWS;
            int col = i % NUM_COLS;
            int value = str.charAt(i) - '0';
			this.values[row][col] = value;
		}
    }

    public void setValue(int row, int col, int value) {
        validatePosition(row, col);
        validateBoardValue(value);

        this.values[row][col] = value;
    }

    public int getValue(int row, int col) {
        validatePosition(row, col);
        return this.values[row][col];
    }

    /** Returns a string representing the Sudoku board in a condensed form.*/
	public String getSimplifiedString() {
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < NUM_CELLS; i++) {
			strb.append(values[i / NUM_ROWS][i % NUM_COLS]);
		}
		return strb.toString().replaceAll("0", ".");
	}

    @Override
	public String toString() {
		StringBuilder strb = new StringBuilder("  ");

	    for (int i = 0; i < NUM_CELLS; i++) {
	    	strb.append(values[i / NUM_ROWS][i % NUM_COLS]);

	        if (((((i+1) % 9) % 3) == 0) && (((i+1) % 9) != 0)) {
	            strb.append(" | ");
	        } else {
	        	strb.append("   ");
	        }

	        if (((i+1) % 9) == 0) {
	        	strb.append(System.lineSeparator());

	        	if (i == NUM_CELLS - 1) {
	        		break;
	        	}

	            if (((Math.floor((i+1) / 9) % 3) == 0) && ((Math.floor(i/9) % 8) != 0)) {
	            	strb.append(" -----------|-----------|------------");
	            	strb.append(System.lineSeparator());
	            } else {
	                strb.append("            |           |            ");
	            	strb.append(System.lineSeparator());
	            }
	            strb.append("  ");
	        }
        }

		return strb.toString().replaceAll("0", ".");
	}
}
