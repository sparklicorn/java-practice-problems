package sparklicorn.loops;

public class LoopsProblem1_Fibonacci {

	/**
	 * Returns the specified number in the fibonacci sequence.
	 * Here are the first few fibonacci numbers:
	 * <br/><code>fib(0) = 0</code>
	 * <br/><code>1, 1, 2, 3, 5, 8, 13, 21,...</code>
	 * @param n The index of the fibonacci number to find.
	 * @return The nth number in the fibonacci sequence.
	 * @throws IllegalArgumentException if input is negative.
	 */
	public static long fib(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		
		if (n == 0)
			return 0L;
		
		long a = 0;
		long b = 0;
		long current = 1;
		for (int i = 1; i < n; i++) {
			a = b;
			b = current;
			current = a + b;
		}

		return current;
	}

}
