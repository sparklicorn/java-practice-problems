package sparklicorn.loops;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LoopsProblem1_FibonacciTest {

	@Test
	public void fib_success() {
		long[] fibSequence = new long[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
		for (int i = 0; i < fibSequence.length; i++) {
			long result = LoopsProblem1_Fibonacci.fib(i);
			assertEquals(
				"fib(" + i + ")",
				fibSequence[i],
				result
			);
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void fib_whenInputIsNegative_ThrowsIllegalArgumentException() {
		LoopsProblem1_Fibonacci.fib(-1);
	}
}
