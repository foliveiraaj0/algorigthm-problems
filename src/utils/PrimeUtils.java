package utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class PrimeUtils {

	public static long getNextPrime(long start) {
		while(!PrimeUtils.isPrime(start)) {
			start++;
		}
		return start;
	}
	
	public static boolean isPrime(long number) {
		
		if(number <= 1) {
			return false;
		}
		
		if(number == 2) {
			return true;
		}
		
		if(number > 2 && number%2 == 0) {
			return false;
		}
		
		long limit = (long) Math.round(Math.sqrt(number)) + 1;
		
		for (long i = 3; i<limit; i+=2) {
			if(i != number) {
				if(number%i == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	@Test
	void testingIsPrime() {
		assertFalse(PrimeUtils.isPrime(0));
		assertFalse(PrimeUtils.isPrime(1));
		assertTrue(PrimeUtils.isPrime(7));
		assertTrue(PrimeUtils.isPrime(673));
		assertFalse(PrimeUtils.isPrime(480009));
	}
	
}
