package sparklicorn.arrays;

public class ArraysProblem4_RotateArray2 {

	/**
	 * Shifts all elements in the NxN array one position "to the left".
	 * For example, the array
	 * <pre>
	 *1  2  3  4               2  3  4  8
	 *5  6  7  8    becomes    1  7  1  2
	 *9  0  1  2               5  6  0  6
	 *3  4  5  6               9  3  4  5
	 </pre>
	 * @param arr The array to rotate.
	 * @throws NullPointerException if <code>arr</code> is null.
	 */
	public static void rotate(int[][] arr) {
		if (arr == null) {
			throw new NullPointerException();
		}
		
		int n = arr.length;
		if (n < 2) {
			return;
		}

		for (int i = 0; i < (n + 1)/2; i++) {
			rotate(arr, i);
		}
	}

	private static void rotate(int[][] arr, int innerIndex) {
		int begin = innerIndex;
		int end = arr.length - (innerIndex * 2);

		int[] headElements = new int[] {
			arr[begin][begin], arr[begin][end], arr[end][end], arr[end][begin]
		};

		for (int i = innerIndex; i < (end - 1); i++) {
			//shift top row
			arr[begin][i] = arr[begin][i + 1];

			//shift right column
			arr[i][end] = arr[i + 1][end];

			//shift bottom row
			arr[end][end - i] = arr[end][end - i - 1];

			//shift left column
			arr[end - i][begin] = arr[end - i - 1][begin];
		}

		arr[begin + 1][begin] = headElements[0];
		arr[begin][end - 1] = headElements[1];
		arr[end - 1][end] = headElements[2];
		arr[end][begin + 1] = headElements[3];
	}
}
