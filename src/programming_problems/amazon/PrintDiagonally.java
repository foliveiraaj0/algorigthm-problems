package programming_problems.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintDiagonally {

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
				mSizeString = reader.readLine();
			} catch (IOException e) {
			}

			int mSize = Integer.parseInt(mSizeString);

			if (mSize > 0) {

				Integer[] M = new Integer[mSize * mSize];

				M = readM(reader);
				
				HashMap<Integer, Integer> d = new HashMap<Integer, Integer>();

				int cr = 0;

				while (cr < mSize) {
					int cc = cr;
					
					if (d.containsKey(cr)) {
						cc = d.get(cr) + 1;
					}

					printDiagonals(M, mSize, d, cr, cc);
					
					cr++;
				}
				System.out.println();
			}
		}

	}
	
	static void printDiagonals(Integer[] M, int mSize, HashMap<Integer, Integer> d, int cr, int cc) {
		
		d.clear();
		
		while (cc < mSize) {
			int ac = cc;
			int ar = cr;
			while (ac >= 0 && ar < mSize) {
				int toPrint = M[ar * mSize + ac];
				System.out.printf("%d ", toPrint);
				if (d.containsKey(ar)) {
					d.remove(ar);
				}
				d.put(ar, ac);
				ar++;
				ac--;
			}
			cc++;
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
		
		return values.toArray(new Integer[0]);

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
}
