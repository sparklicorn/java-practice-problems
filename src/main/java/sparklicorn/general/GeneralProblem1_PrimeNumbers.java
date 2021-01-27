package sparklicorn.general;

public class GeneralProblem1_PrimeNumbers {

	/**
	 * Determines if the given number is prime.
	 * A prime number can only be divide evenly by 1 and itself.
	 * @param n Number to check.
	 * @return True if n is a prime number; otherwise false.
	 */
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		if (n == 2) {
			return true;
		}

		if (n % 2 == 0) {
			return false;
		}

		int sqrt = (int) Math.ceil(Math.sqrt(n)) + 1;
		for (int x = 3; x < sqrt; x+=2) {
			if (n % x == 0) {
				return false;
			}
		}

		return true;
	}
}
