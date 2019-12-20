package problems.amazon;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class NutsAndBolts {
	public static void main(String[] args) {

		HashMap<Integer, String> orderedMapCharacters = buildOrderedMapCharacters();

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

			String nuts = null;

			try {
				nuts = reader.readLine().trim();
			} catch (IOException e) {
			}

			String bolts = null;

			try {
				bolts = reader.readLine().trim();
			} catch (IOException e) {
			}

			String ans = solution(nuts, bolts, orderedMapCharacters);
			System.out.println(ans);
			System.out.println(ans);
		}

	}

	static String solution(String nuts, String bolts, HashMap<Integer, String> orderedMapCharacters) {
		String ans = "";
		int len = orderedMapCharacters.size();
		for (int i = 0; i < len; i++) {
			String character = orderedMapCharacters.get(i);
			if (nuts.contains(character) && bolts.contains(character)) {
				ans += character + " ";
			}
		}

		if (!ans.isEmpty()) {
			ans = ans.substring(0, ans.length() - 1);
		}
		return ans;
	}

	static HashMap<Integer, String> buildOrderedMapCharacters() {
		HashMap<Integer, String> orderedMapCharacters = new HashMap<Integer, String>();

		orderedMapCharacters.put(0, "!");
		orderedMapCharacters.put(1, "#");
		orderedMapCharacters.put(2, "$");
		orderedMapCharacters.put(3, "%");
		orderedMapCharacters.put(4, "&");
		orderedMapCharacters.put(5, "*");
		orderedMapCharacters.put(6, "@");
		orderedMapCharacters.put(7, "^");
		orderedMapCharacters.put(8, "~");

		return orderedMapCharacters;
	}

	@Test
	void testSolution() {
		HashMap<Integer, String> orderedMapCharacters = new HashMap<Integer, String>();
		assertTrue(solution("@ % $ # ^", "% @ # $ ^", orderedMapCharacters).equals("# $ % @ ^"));
	}
}
