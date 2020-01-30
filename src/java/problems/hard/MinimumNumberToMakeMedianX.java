package problems.hard;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class MinimumNumberToMakeMedianX {

	public static void main(String[] args) {

	}

	static int solution(Integer x, Integer[] a) {
		sort(a);
		int odd = oddSolution(x, a);
		int even = evenSolution(x, a);
		System.out.println(Math.min(odd, even));
		return Math.min(odd, even);
	}

	static int oddSolution(Integer x, Integer[] a) {
		int pos = bSearch(a, x);
		return calculateOddSolution(Math.abs(pos), x, a);
	}

	static int bSearch(Integer[] a, int target) {
		int pos = Collections.binarySearch(Arrays.asList(a), target);
		if (pos < 0) {
			pos += 1;
		}
		return pos;
	}

	static int calculateOddSolution(int pos, int x, Integer[] a) {
		int inc = pos < a.length && a[pos] != x ? 1 : 0;
		int len = a.length + inc;
		int left = pos;
		int right = len - left - 1;
		return Math.abs(right - left) + inc;
	}

	static int evenSolution(Integer x, Integer[] a) {
		int pos = a.length / 2;
		int inc = x > a[pos] ? 1 : -1;
		int steps = 0;
		int value = -1;
		while (pos > 0 && pos < a.length) {
			value = findValue(x, pos, inc, a);
			if (value != -1) {
				break;
			}
			pos += inc;
			steps++;
		}
		return calculateEvenSolution(pos, steps, value, inc, a);
	}

	static int calculateEvenSolution(int pos, int steps, int value, int inc, Integer[] a) {

		int len = a.length;
		boolean valueAdded = value < 0;

		if (valueAdded) {
			len += 1;
		}

		int leftPos = pos + (steps * inc);

		if ((!valueAdded && inc < 0) || inc > 0) {
			leftPos--;
		}

		int left = leftPos;

		int right = len - left - 2;

		inc = valueAdded ? 1 : 0;

		return Math.abs(right - left) + inc;
	}

	static int findValue(int x, int pos, int inc, Integer[] a) {
		int value = x * 2 - a[pos];
		int valuePos = bSearch(a, value);
		//boolean insertingInTheEnd = valuePos == a.length;
		if(valuePos < 0 && Math.abs(valuePos) < pos) {
			pos += 1;
		}
		boolean valueIsValid = valuePos == pos + inc;
		if (valueIsValid) {
			return value;
		}
		return -1;
	}

	static void sort(Integer[] a) {
		Collections.sort(Arrays.asList(a));
	}

	@Test
	void testFindValue() {
		/*
		 * int x = 14; int pos = 2; int inc = -1; Integer[] a = new Integer[] { 8, 12,
		 * 16, 18, 20 }; assertTrue(findValue(x, pos, inc, a) == 12);
		 * 
		 * x = 14; pos = 3; inc = -1; a = new Integer[] { 8, 12, 15, 16, 18, 20 };
		 * assertTrue(findValue(x, pos, inc, a) == -1);
		 * 
		 * x = 14; pos = 2; inc = -1; a = new Integer[] { 8, 12, 15, 16, 18, 20 };
		 * assertTrue(findValue(x, pos, inc, a) == 13);
		 * 
		 * x = 18; pos = 2; inc = 1; a = new Integer[] { 8, 12, 15, 16, 40, 50 };
		 * assertTrue(findValue(x, pos, inc, a) == 20);
		 */
	}

	@Test
	void testOddCalculus() {

		int x = 6;
		int pos = 2;
		Integer[] a = new Integer[] { 4, 5, 7 };
		assertTrue(calculateOddSolution(pos, x, a) == 2);

		x = 3;
		pos = 0;
		a = new Integer[] { 4, 5 };
		assertTrue(calculateOddSolution(pos, x, a) == 3);

		x = 12;
		pos = 3;
		a = new Integer[] { 8, 9, 10 };
		assertTrue(calculateOddSolution(pos, x, a) == 4);

		x = 12;
		pos = 2;
		a = new Integer[] { 8, 9, 12, 13, 14 };
		assertTrue(calculateOddSolution(pos, x, a) == 0);

		x = 12;
		pos = 1;
		a = new Integer[] { 8, 12, 13, 14 };
		assertTrue(calculateOddSolution(pos, x, a) == 1);

		x = 12;
		pos = 2;
		a = new Integer[] { 8, 9, 12, 14 };
		assertTrue(calculateOddSolution(pos, x, a) == 1);
	}

	@Test
	void testEvenCalculus() {
		int pos = 2;
		int steps = 0;
		int value = 14;
		int inc = -1;
		Integer[] a = new Integer[] { 8, 12, 16, 18, 20 };
		assertTrue(calculateEvenSolution(pos, steps, value, inc, a) == 1);

		pos = 2;
		steps = 1;
		value = 13;
		inc = -1;
		a = new Integer[] { 8, 12, 16, 18, 20 };
		assertTrue(calculateEvenSolution(pos, steps, value, inc, a) == 3);
	}

	@Test
	void testSort() {
		Integer[] a = new Integer[] { 5, 2, 10 };
		sort(a);
		assertTrue(a[0] == 2);
		assertTrue(a[2] == 10);
	}

	@Test
	void testSolution() {

		Integer x = 3;
		Integer[] a = new Integer[] { 4, 5 };
		assertTrue(solution(x, a) == 3);

		x = 12;
		a = new Integer[] { 8, 9, 10 };
		assertTrue(solution(x, a) == 3);

		x = 6;
		a = new Integer[] { 4, 5, 7 };
		assertTrue(solution(x, a) == 2);

		x = 15;
		a = new Integer[] { 8, 12, 16, 18, 20 };
		assertTrue(solution(x, a) == 1);

		x = 14;
		a = new Integer[] { 7, 8, 12, 16, 18, 20 };
		assertTrue(solution(x, a) == 0);

		x = 14;
		a = new Integer[] { 12, 15, 16, 18, 20 };
		assertTrue(solution(x, a) == 3);

	}

}
