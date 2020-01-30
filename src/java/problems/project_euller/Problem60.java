package problems.project_euller;

import utils.PrimeUtils;

public class Problem60 {

	static long[] primes;

	static int currentPrimesCount;

	static long lowestSum;

	static long currentFirstPrime;

	static long current;

	static int primesLength = 5;

	static long[] bestPrimes;
	
	static boolean enablePrintState = true;

	public static void main(String[] args) {

		reset(primesLength);

		while (currentFirstPrime < lowestSum / 5) {

			iterateCurrent();

			boolean concatenatesAreValid = validateConcatenates();

			if (!concatenatesAreValid) {
				current++;
			} else {
				primes[currentPrimesCount] = current;
				currentPrimesCount++;
				if (currentPrimesCount < primes.length) {
					current++;
				} else {
					long sum = getSum();
					if (lowestSum > sum) {
						lowestSum = sum;
						for (int i = 0; i < primes.length; i++) {
							bestPrimes[i] = primes[i];
						}
					}
				}
			}
		}
		printResults();
	}

	private static boolean validateConcatenates() {
		for (int i = 0; i < currentPrimesCount; i++) {
			long conc1 = concatenate(current, primes[i]);
			long conc2 = concatenate(primes[i], current);
			if (!PrimeUtils.isPrime(conc1) || !PrimeUtils.isPrime(conc2)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * If the current sum is already bigger than the lowestSum then the algorithm
	 * should give up of the current prime place, get back to the previous prime
	 * place and iterate it. example: if the lowest sum is 11 and the prime array is
	 * [1,5,0,0] and the current third value being tested is 7 ([1,5,7,0]) then the
	 * sum is already bigger than 11 which is the lowest sum, so the primes array
	 * will change to [1,0,0,0] and will test the next value [1,7,0,0]
	 */
	private static void iterateCurrent() {

		current = PrimeUtils.getNextPrime(current);

		long maxToReach = primesLength - currentPrimesCount > 1 ? (current * (primesLength - currentPrimesCount - 1))
				: current;

		long sum = getSum() + maxToReach;

		if (sum > lowestSum) {
			currentPrimesCount--;
			if (currentPrimesCount == 0) {
				iterateCurrentFirst();
			} else {
				primes[currentPrimesCount] = 0;
				currentPrimesCount--;
				if (currentPrimesCount == 0) {
					iterateCurrentFirst();
				} else {
					current = PrimeUtils.getNextPrime(primes[currentPrimesCount] + 1);
					primes[currentPrimesCount] = 0;
				}
			}
		}

	}

	private static void iterateCurrentFirst() {
		currentFirstPrime = PrimeUtils.getNextPrime(currentFirstPrime + 1);
		printState();
		primes[0] = currentFirstPrime;
		currentPrimesCount = 1;
		current = PrimeUtils.getNextPrime(currentFirstPrime + 1);
	}

	private static void reset(int arrayLength) {
		primes = new long[arrayLength];
		bestPrimes = new long[primesLength];
		currentPrimesCount = 1;
		startTheFirstPrime();
		primes[0] = currentFirstPrime;
		current = PrimeUtils.getNextPrime(currentFirstPrime + 1);
		printState();
	}

	/*
	 * Starting with 2 will test the whole numbers in the positive 'long' range for the
	 * second prime place because the concatenation will always return false.
	 * Starting with 3 will take too long because the lowestSum will be
	 * Long.MaxValue, it will work though. Starting with 1 is the best way to get
	 * the correct answer fast, but 1 is not prime.
	 */
	private static void startTheFirstPrime() {
		lowestSum = Integer.MAX_VALUE; //Long.MAX_VALUE;
		currentFirstPrime = 1; //3
	}

	private static long getSum() {
		long sum = 0;
		for (int i = 0; i < primes.length; i++) {
			sum += primes[i];
		}
		return sum;
	}

	private static long concatenate(long n1, long n2) {
		String concatString = String.format("%d%d", n1, n2);
		long number = (long) Long.parseLong(concatString);
		return number;
	}

	private static void printState() {
		if(enablePrintState) {
			System.out.printf(String.format("currentFirst: %d, lowestSum: %d, primes: ", currentFirstPrime, lowestSum));
			printBestPrimes();
		}
	}

	private static void printResults() {
		System.out.println("----- last result ----");
		printBestPrimes();
		System.out.println("sum is " + lowestSum);
		System.out.println(" ----");
	}

	private static void printBestPrimes() {
		System.out.print("[");
		for (int i = 0; i < bestPrimes.length; i++) {
			System.out.print(bestPrimes[i] + ",");
		}
		System.out.println("]");
	}

}
