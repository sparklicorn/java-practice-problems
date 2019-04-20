package sparklicorn.arrays;

public class ArraysProblem2_MinAndMax {

	/**
	 * Finds the minimum and maximum values in the given list.
	 * <br/>This method shall not mutate the given list.
	 * @param list An array of integers.
	 * @return An integer array containing two elements:
	 * <code>{ minimumValue, maximumValue }</code>.
	 * @throws IllegalArgumentException if the list is empty or null.
	 */
	public static int[] findMinAndMax(int[] list) {
		if (list == null || list.length == 0)
			throw new IllegalArgumentException();
		
		int min = list[0], max = min;
		for (int e : list) {
			if (e < min)
				min = e;
			if (e > max)
				max = e;
		}

		return new int[] { min, max };
	}
}
