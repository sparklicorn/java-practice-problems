package sparklicorn.arrays;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

public class ArraysProblem3_RotateArrayTest {

	@Test(expected=NullPointerException.class)
	public void rotate_whenInputIsNull_throwsNullPointerException() {
		ArraysProblem3_RotateArray.rotate(null);
	}
	
	@Test
	public void rotate() throws FileNotFoundException {
		int[][][] testCases = new int[][][] {
			//new int[][] { inputArray, expected },
			new int[][] { new int[0], new int[0] },
			new int[][] { new int[] { 1 }, new int[] { 1 } },
			new int[][] { new int[] { 2, 3, 4 }, new int[] { 3, 4, 2 } },
			new int[][] { new int[] { 5, 9, 8, 7, 6 }, new int[] { 9, 8, 7, 6, 5 } }
		};
		
		for (int[][] testCase : testCases) {
			int[] input = testCase[0];
			int[] expected = testCase[1];
			ArraysProblem3_RotateArray.rotate(input);
			
			assertArrayEquals(expected, input);
		}
	}
}
