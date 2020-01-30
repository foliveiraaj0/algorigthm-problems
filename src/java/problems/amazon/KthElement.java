package problems.amazon;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import utils.ArrayUtils;

public class KthElement {
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
			
			String kString = "";
			try {
				kString = reader.readLine();
			} catch (IOException e) {
			}
			
			int k = Integer.parseInt(kString);

			if (arrString != null && arrString.length != 0) {
				Integer[] arr = new Integer[arrString.length];
				for (int j = 0; j < arr.length; j++) {
					arr[j] = Integer.parseInt(arrString[j]);
				}
				System.out.println(solution(arr, k));
			}
		}
	}

	static int solution(Integer[] A, int k) {
		Collections.sort(Arrays.asList(A));
		return A[k-1]; 
	}

	@Test
	void testSolution() {
		assertTrue(solution(new Integer[] { 7, 10, 4, 3, 20, 15 }, 3) == 7);
		assertTrue(solution(new Integer[] { 7, 10, 4, 20, 15 }, 4) == 15);
		
	}

}
