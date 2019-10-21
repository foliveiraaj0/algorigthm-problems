package utils;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ArrayUtils {

	public static int[] toIntArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

	public static char[] toCharArray(List<Character> list) {
		char[] ret = new char[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

	public static void printInt(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printChar(char[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}

	public static int[] goLeft(int[] pos, int[][] m, int[] forbidenValues) {
		if (pos[1] > 0) {
			int leftPos = pos[1] - 1;
			if (forbidenValues != null) {
				int posValue = m[pos[0]][leftPos];
				if (isForbidenValue(forbidenValues, posValue)) {
					return null;
				}
			}
			return new int[] { pos[0], leftPos };

		}
		return null;
	}

	public static int[] goRight(int[] pos, int[][] m, int[] forbidenValues) {
		if (pos[1] < m.length - 1) {
			int rightPos = pos[1] + 1;
			int posValue = m[pos[0]][rightPos];
			// considering squared matrix
			if (forbidenValues != null) {
				if (isForbidenValue(forbidenValues, posValue)) {
					return null;
				}
			}
			return new int[] { pos[0], rightPos };
		}
		return null;
	}

	public static int[] goUp(int[] pos, int[][] m, int[] forbidenValues) {
		if (pos[0] > 0) {
			int upPos = pos[0] - 1;
			int posValue = m[upPos][pos[1]];
			if (forbidenValues != null) {
				if (isForbidenValue(forbidenValues, posValue)) {
					return null;
				}
			}
			return new int[] { upPos, pos[1] };
		}
		return null;
	}

	public static int[] goDown(int pos[], int[][] m, int[] forbidenValues) {
		if (pos[0] < m.length - 1) {
			int downPos = pos[0] + 1;
			int posValue = m[pos[0] + 1][pos[1]];
			// considering squared matrix
			if (forbidenValues != null) {
				if (isForbidenValue(forbidenValues, posValue)) {
					return null;
				}
			}			return new int[] { downPos, pos[1] };
		}
		return null;
	}

	private static boolean isForbidenValue(int[] forbidenValues, int posValue) {
		for (int i = 0; i < forbidenValues.length; i++) {
			if (posValue == forbidenValues[i]) {
				return true;
			}
		}
		return false;
	}

	public static void fillMatrix(String s, int[][] m) {

		int N = m.length;

		char[] rowArray = new char[N * N];

		s.getChars(0, rowArray.length, rowArray, 0);

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				m[j][k] = Integer.parseInt("" + rowArray[N * j + k]);
			}
		}
	}

	public static void fillMatrix(String s, int[][] m, char separator) {

		int N = m.length;

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				int index = s.indexOf(separator);
				if (index != -1) {
					m[j][k] = Integer.parseInt(s.substring(0, index));
					s = s.substring(index + 1);
				} else {
					m[j][k] = Integer.parseInt(s.substring(0));
					break;
				}
			}
		}
	}

	@Test
	void testToIntArray() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(3);
		int[] arr = toIntArray(list);
		assertTrue(arr.length == list.size());
		assertTrue(arr[2] == 3);

	}

	@Test
	void testToCharArray() {
		List<Character> list = new ArrayList<Character>();
		list.add('e');
		list.add('b');
		list.add('q');
		char[] arr = toCharArray(list);
		assertTrue(arr.length == list.size());
		assertTrue(arr[1] == 'b');
	}

	@Test
	void testFillMatrix() {
		String values = "31 100 65 12 18 10 13 47 157 6 100 113 174 11 33 88 124 41 20 140 99 32 111 41 20 ";
		int[][] m = new int[5][5];
		fillMatrix(values, m, ' ');
		assertTrue(m[2][1] == 113);
		assertTrue(m[4][4] == 20);
		assertTrue(m[0][4] == 18);
	}
}
