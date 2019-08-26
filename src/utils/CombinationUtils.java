package utils;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class CombinationUtils {

	public static int sumComb(int n) {
		return sumComb(n, n);
	}
	
	public static int sumComb(int n, int limit) {
		int sum = 0;
		for (int i = 0; i < limit; i++) {
			sum += combination(n, i);
		}
		return sum;
	}

	public static int combination(int n, int base) {
		long res = (fact(n) / (fact(base) * fact(n - base)));
		return (int) res ;
	}

	public static long fact(int n) {
		long res = 1;
		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
	}
	
	@Test
	void testingIsPrime() {
		int ac=1;
		for (int i = 1; i < 14; i++) {
			assertTrue(sumComb(i) == ac);
			ac = 1 + 2*ac;
		}
	}
}
