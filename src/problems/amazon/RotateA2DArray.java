package problems.amazon;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

public class RotateA2DArray {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String TString = "";
		try {
			TString = reader.readLine();
		} catch (IOException e) {
		}

		int T = Integer.parseInt(TString);
		for (int i = 0; i < T; i++) {
			String nString = "";
			try {
				nString = reader.readLine();
			} catch (IOException e) {
			}

			int N = Integer.parseInt(nString);

			String[] arrString = null;

			try {
				arrString = reader.readLine().trim().split(" ");
			} catch (IOException e) {
			}

			if (arrString != null && arrString.length != 0) {
				solution(arrString);
				System.out.println(String.join(" ", arrString));
			}
		}
	}

	static void solution(String[] array) {
		int len = (int) Math.sqrt(array.length);
		int left = 0;
		while (left < len / 2) {
			for (int i = left; i < len - left - 1; i++) {
				String mem = null;
				int lastX = -1;
				int lastY = -1;
				for (int j = 0; j < 4; j++) {
					if (mem == null) {
						lastX = left;
						lastY = i;
						mem = array[lastX * len + lastY];
					}
					int x = lastY;
					// the last index of the current square being evaluated
					// if the matrix has length 4 and left is 1 then the lastCIndex is 1
					// because the square being evaluated has length 2 and the columns are 0 and 1
					int lastCIndex = (len - 1) - (left * 2);
					int y = lastCIndex - (lastX - left) + left;
					String aux = array[x * len + y];
					array[x * len + y] = mem;
					mem = aux;
					lastX = x;
					lastY = y;
				}
			}
			left++;
		}
	}

	@Test
	void testSolution() {
		String[] array = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		solution(array);
		assertTrue(String.join(" ", array).equals("7 4 1 8 5 2 9 6 3"));

		array = new String[] { "1", "2", "3", "4" };
		solution(array);
		assertTrue(String.join(" ", array).equals("3 1 4 2"));

		array = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" };
		solution(array);
		assertTrue(String.join(" ", array).equals("13 9 5 1 14 10 6 2 15 11 7 3 16 12 8 4"));

		array = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25" };
		solution(array);
		assertTrue(String.join(" ", array).equals("21 16 11 6 1 22 17 12 7 2 23 18 13 8 3 24 19 14 9 4 25 20 15 10 5"));
	}
}
