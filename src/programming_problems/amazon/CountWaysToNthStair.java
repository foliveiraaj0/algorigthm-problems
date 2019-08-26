package programming_problems.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountWaysToNthStair {

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
			
			System.out.println(countWays(N));
			
		}
	}
	
	static Long countWays(int m){
		return new Long(m/2+1);
	}
}
