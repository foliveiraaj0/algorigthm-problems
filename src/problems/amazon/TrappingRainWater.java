package problems.amazon;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TrappingRainWater {
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
				int[] arr = new int[arrString.length];
				for (int j = 0; j < arr.length; j++) {
					arr[j] = Integer.parseInt(arrString[j]);
				}
				System.out.println(solution(arr));
			}
		}
	}

	static int solution(int[] A) {
		int left = 0;

		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[left]) {
				break;
			} else {
				left = i;
			}
		}
		
		int sum = 0;
		
		for (int i = left+1; i < A.length; i++) {
			if(A[i] >= A[left]) {
				if(i > left + 1) {
					int w = i - left - 1;
					int h = A[left] > A[i] ? A[i] : A[left];
					int[] area = Arrays.copyOfRange(A, left + 1, i);
					sum += ((w * h) - Arrays.stream(area).sum());
				}
				left = i;
			}
		}

		int[] sorted = Arrays.copyOfRange(A.clone(), left + 1, A.length);
		Arrays.sort(sorted);
		int sIndex = sorted.length - 1;

		for (int i = left; i < A.length; i++) {
			if (sIndex != -1) {
				if (A[i] == sorted[sIndex]) {
					if (i > left + 1) {
						int w = i - left - 1;
						int h = A[left] > A[i] ? A[i] : A[left];
						int[] area = Arrays.copyOfRange(A, left + 1, i);
						sum += ((w * h) - Arrays.stream(area).sum());
					}
					left = i;
					sorted = Arrays.copyOfRange(A.clone(), left + 1, A.length);
					Arrays.sort(sorted);
					sIndex = sorted.length - 1;
				}
			}
		}

		return sum;

	}

	@Test
	void testSolution() {
		
		assertTrue(solution(new int[] { 7, 8, 3, 5, 1, 2, 0 }) == 3);
		assertTrue(solution(new int[] { 2, 1, 6, 8, 5 }) == 1);
		assertTrue(solution(new int[] { 4, 4, 4 }) == 0);
		assertTrue(solution(new int[] { 3, 4, 5, 0, 0 }) == 0);

		assertTrue(solution(new int[] { 3, 0, 0, 2, 0, 4 }) == 10);
		assertTrue(solution(new int[] { 7, 4, 0, 9 }) == 10);
		assertTrue(solution(new int[] { 6, 9, 9 }) == 0);
		assertTrue(solution(new int[] { 8, 8, 2, 4, 5, 5, 1 }) == 4);

		int[] test = new int[100];
		int s = 50;
		int sum = 0;
		for (int i = 0; i < test.length; i++) {
			test[i] = i % 2 == 0 ? s-- : 0;
			sum += test[i];
		}
		sum -= test[0] - test[test.length - 1];
		assertTrue(solution(test) == sum);

		assertTrue(solution(new int[] { 1, 1, 5, 2, 7, 6, 1, 4, 2, 3 }) == 7);
	}
}
