package problems.amazon;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

public class PowerOf2 {
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

			System.out.println(solution(nString) ? "YES" : "NO");
		}

	}

	static boolean solution(String numberString) {
		long number = Long.parseLong(numberString);
		String bits = Long.toBinaryString(number);
		if (bits.length() == 1) {
			return number == 1;
		} else {
			String zeros = bits.substring(1, bits.length());
			String one = bits.substring(0, 1);
			return !zeros.contains("1") && one.equals("1");
		}
	}

	@Test
	void testSolution() {
		assertFalse(solution("0"));
		assertFalse(solution("3"));
		assertFalse(solution("19999947853"));
		assertTrue(solution("1"));
		assertTrue(solution("128"));
		assertTrue(solution("4096"));
	}
}
