package programming_problems.amazon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import utils.CombinationUtils;

public class CountSubsequencesOfTypeABC {
	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String TString = "";
		try {
			TString = reader.readLine();
		} catch (IOException e) {
		}

		int T = Integer.parseInt(TString);
		for (int i = 0; i < T; i++) {
			String S = "";
			try {
				S = reader.readLine();
			} catch (IOException e) {
			}

			System.out.println(count(S));
		}
	}

	static int count(String S) {
		int sum = 0;
		int aStack = 0;
		int bStack = 0;
		int cStack = 0;
		int aIndex = S.indexOf('a');

		while (aIndex != -1) {
			bStack = 0;
			int currentSum = 0;
			int bIndex = getNextIndex(S, aIndex + 1, 'b');
			while (bIndex != -1) {
				cStack = 0;
				int cIndex = getNextIndex(S, bIndex + 1, 'c');
				while (cIndex != -1) {
					cStack++;
					cIndex = getNextIndex(S, cIndex + 1, 'c');
				}
				currentSum += sumComb(cStack) * (sumComb(bStack) + 1);
				bIndex = getNextIndex(S, bIndex + 1, 'b');
				bStack++;
			}
			sum += currentSum * (sumComb(aStack) + 1);
			aIndex = getNextIndex(S, aIndex + 1, 'a');
			aStack++;
		}

		return sum;
	}

	static int getNextIndex(String S, int currentIndex, char letter) {
		if (currentIndex < S.length()) {
			String prefix = S.substring(0, currentIndex);
			currentIndex = S.substring(prefix.length()).indexOf(letter);
			if (currentIndex != -1) {
				currentIndex += prefix.length();
			}
		} else {
			currentIndex = -1;
		}
		return currentIndex;
	}

	static int calculateStack(int aStack, int bStack, int cStack) {
		int aComb = aStack > 0 ? sumComb(aStack) : 0;
		int bComb = bStack > 0 ? sumComb(bStack) : 0;
		int cComb = cStack > 0 ? sumComb(cStack) : 0;

		return aComb * bComb * cComb;
	}

	static int sumComb(int n) {
		return CombinationUtils.sumComb(n, n);
	}

	@Test
	void count() {
		assertEquals(count("bbccaac"), 0);
		assertEquals(count("abbc"), 3);
		assertEquals(count("abcabc"), 7);
		assertEquals(count("abbcabc"), 15);
		assertEquals(count("aabcbc"), 15);
		assertEquals(count("abccbcc"), 21);
		assertEquals(count("babcbbaabc"), 23);
		assertEquals(count("aabcbcbc"), 51);
		assertEquals(count("aabbcaabc"), 51);
		assertEquals(count("bcbcbcbaabbccaac"), 63);
		assertEquals(count("aabbccc"), 63);
		// abbcabc = 15, abc abc abcc abc abc abcc abbc abbc abbcc abc abbc abbc abbbc
		// abc aabc
		
		// aabcbcbc = 51, (abc abc abc abcc abcc abcc abccc abc abc abcc abbc abbc abbcc
		// abc abbc abbc abbbc) * 3
		
		// abccbcc = 21, abc *4 abcc *6 abccc *4 abcccc abc abc abcc abbc abbc abbcc
	}

	@Test
	void submission() {
		assertEquals(count("babcbbaabcbcbcbaabbccaac"), 9087);
		assertEquals(count("acbcccbaccacaabcbaaccbcabccbccbcbb"), 119295);
	}

}
