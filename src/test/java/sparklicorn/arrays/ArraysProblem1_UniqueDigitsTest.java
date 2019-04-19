package sparklicorn.arrays;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ArraysProblem1_UniqueDigitsTest {

	@Test(expected=NullPointerException.class)
	public void hasUniqueDigits_whenArrayIsNull_throwsNullPointerException() {
		ArraysProblem1_UniqueDigits.hasUniqueDigits(null);
	}
	
	@Test
	public void hasUniqueDigits_whenArrayIsEmpty_returnsTrue() {
		assertEquals(true, ArraysProblem1_UniqueDigits.hasUniqueDigits(new int[] {}));
	}
	
	@Test
	public void hasUniqueDigits_whenArrayHasDuplicateDigits_returnsFalse() {
		int[][] arrays = new int[][] {
			new int[] { 1, 1, 3, 4, 5, 6, 7, 8, 9 },
			new int[] { 2, 2, 3, 4, 5, 6, 7, 8, 9 },
			new int[] { 3, 2, 3, 4, 5, 6, 7, 8, 9 },
			new int[] { 4, 2, 3, 4, 5, 6, 7, 8, 9 },
			new int[] { 5, 2, 3, 4, 5, 6, 7, 8, 9 },
			new int[] { 6, 2, 3, 4, 5, 6, 7, 8, 9 },
			new int[] { 7, 2, 3, 4, 5, 6, 7, 8, 9 },
			new int[] { 8, 2, 3, 4, 5, 6, 7, 8, 9 },
			new int[] { 9, 2, 3, 4, 5, 6, 7, 8, 9 },
		};
		
		for (int[] arr : arrays) {
			assertEquals(false, ArraysProblem1_UniqueDigits.hasUniqueDigits(arr));
		}
	}
	
	@Test
	public void hasUniqueDigits_whenArrayHasLargeNumbers_returnsFalse() {
		int[][] arrays = new int[][] {
			new int[] { 10 },
			new int[] { 11 },
			new int[] { Integer.MAX_VALUE }
		};
		
		for (int[] arr : arrays) {
			assertEquals(false, ArraysProblem1_UniqueDigits.hasUniqueDigits(arr));
		}
	}
	
	@Test
	public void hasUniqueDigits_whenArrayHasNonPositiveNumbers_returnsFalse() {
		int[][] arrays = new int[][] {
			new int[] { 0 },
			new int[] { -1 },
			new int[] { -10 },
			new int[] { Integer.MIN_VALUE }
		};
		
		for (int[] arr : arrays) {
			assertEquals(false, ArraysProblem1_UniqueDigits.hasUniqueDigits(arr));
		}
	}
	
	@Test
	public void hasUniqueDigits_whenArrayHasOnlyDigits_andNoDuplicates_returnsTrue() {
		List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		for (List<Integer> permutation : perms(digits)) {
			assertEquals(
				true,
				ArraysProblem1_UniqueDigits.hasUniqueDigits(
					permutation.stream().mapToInt(i -> i).toArray()
				)
			);
		}
	}
	
	//Returns all permutations of a given list
	private static <T> Set<List<T>> perms(List<T> list) {
	    HashSet<List<T>> resultSet = new HashSet<>();
	    if (list.size() == 1) {
	        resultSet.add(list);
	    } else if (list.size() > 1) {
	        for (T e : list) {
	            List<T> sublist = new ArrayList<>(list);
	            sublist.remove(e);
	            Set<List<T>> r = perms(sublist);
	            for (List<T> x : r) {
	                x.add(e);
	                resultSet.add(x);
	            }
	        }
	    }
	    return resultSet;
	}
}
