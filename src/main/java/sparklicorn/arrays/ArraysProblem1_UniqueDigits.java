package sparklicorn.arrays;

public class ArraysProblem1_UniqueDigits {

	/**
	 * Checks whether the given array contains the digits 1 through 9
	 * with no duplicates.
	 * <br/>This method shall not alter the array.
	 * @param arr int array to check.
	 * @return True if there are no duplicate digits within the array;
	 * otherwise false. If the given array has a length longer than 9,
	 * returns false.
	 * @throws NullPointerException if arr is null.
	 */
	public static boolean hasUniqueDigits(int[] arr) {
		if (arr.length == 0)
			return true;
		if (arr.length > 9)
			return false;
		
		boolean[] digitTracker = new boolean[10];
		for (int n : arr) {
			if (n < 1 || n > 9 || digitTracker[n]) {
				return false;
			} else {
				digitTracker[n] = true;
			}
		}
		
		return true;
	}
}
