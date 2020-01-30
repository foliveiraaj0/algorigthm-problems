package problems.hard;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LargestRectangleOf1 {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String TString = "";
		try {
			TString = reader.readLine();
		} catch (IOException e) {
		}

		int T = Integer.parseInt(TString);
		for (int i = 0; i < T; i++) {

			String mSizeString = "";
			try {
				mSizeString = reader.readLine().trim();
			} catch (IOException e) {
			}

			int separatorIndex = mSizeString.indexOf(' '); 
			
			int h = Integer.parseInt(mSizeString.substring(0, separatorIndex));

			int w = Integer.parseInt(mSizeString.substring(separatorIndex+1));

			Integer[] m = new Integer[h * w];

			m = readM(reader);

			System.out.println(solution(w, m));
		}
	}

	static Integer[] readM(BufferedReader reader) {
		String mString = "";
		try {
			mString = reader.readLine().trim();
		} catch (IOException e) {
		}

		List<Integer> values = new ArrayList<Integer>();

		fillValues(values, mString);

		return values.stream().toArray(Integer[]::new);

	}

	static void fillValues(List<Integer> values, String mString) {

		int nextSpace = mString.indexOf(" ");

		while (nextSpace != -1) {
			String stringValue = mString.substring(0, nextSpace);
			values.add(Integer.parseInt(stringValue));
			mString = mString.substring(nextSpace + 1);
			nextSpace = mString.indexOf(" ");
		}
		values.add(Integer.parseInt(mString));

	}

	static int solution(int w, Integer[] m) {
		transform(w, m);
		sort(w, m);
		int max = 0;
		int hAcc = 0;
		for (int i = m.length - 1; i >= 0; i--) {
			if ((i + 1) % w == 0 || m[i] == 0) {
				hAcc = 0;
			}

			if (m[i] != 0) {
				hAcc++;
				int acc = m[i] * hAcc;
				if (acc > max) {
					max = acc;
				}
			}
		}
		return max;
	}

	static void transform(int w, Integer[] m) {
		for (int i = m.length - 1; i >= w; i--) {
			m[i - w] = m[i - w] > 0 ? m[i] + 1 : 0;
		}
	}

	static void sort(int w, Integer[] m) {
		for (int i = 0; i < m.length; i += w) {
			Integer[] sorted = Arrays.stream(Arrays.copyOfRange(m, i, i + w)).sorted().toArray(Integer[]::new);
			for (int j = 0; j < sorted.length; j++) {
				m[i + j] = sorted[j];
			}
		}
	}

	@Test
	void testSort() {
		int w = 6;
		Integer[] m = new Integer[] { 0, 0, 3, 3, 2, 0, 0, 0, 2, 2, 1, 0 };
		sort(w, m);
		assertTrue(m[0] == 0);
		assertTrue(m[3] == 2);
		assertTrue(m[5] == 3);
		assertTrue(m[9] == 1);
		assertTrue(m[10] == 2);
		assertTrue(m[11] == 2);
	}

	@Test
	void testMatrixTransformation() {
		int w = 2;
		Integer[] m = new Integer[] { 0, 1, 1, 1 };
		transform(w, m);
		assertTrue(m[1] == 2);

		w = 6;
		m = new Integer[] { 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0 };
		transform(w, m);
		assertTrue(m[2] == 3);
		assertTrue(m[4] == 2);
		assertTrue(m[9] == 2);
	}

	@Test
	void testSolution() {
		int w = 6;
		Integer[] m = new Integer[] { 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1,
				1, 1, 0 };
		assertTrue(solution(w, m) == 6);

		w = 4;
		m = new Integer[] { 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1 };
		assertTrue(solution(w, m) == 6);

		w = 4;
		m = new Integer[] { 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1 };
		assertTrue(solution(w, m) == 4);

	}
}
