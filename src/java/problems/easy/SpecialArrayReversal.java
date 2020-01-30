package problems.easy;
import java.io.*;

class SpecialArrayReversal {
	public static void main (String[] args) {
	    BufferedReader reader =
                   new BufferedReader(new InputStreamReader(System.in));
        String TString = "";
        try {
            TString = reader.readLine();    
        }catch(IOException e) {
        }
        
        int T = Integer.parseInt(TString);
		for (int i = 0; i < T; i++) {
		    String S = "";
		    try {
                S = reader.readLine();    
            }catch(IOException e) {
            }
			char[] current = S.toCharArray();
			for(int leftPos = 0, rightPos = current.length - 1; leftPos < rightPos;) {
				while(leftPos < rightPos && isSpecialCharacter(current[leftPos])) {
					leftPos++;
				}
				
				while(leftPos < rightPos && isSpecialCharacter(current[rightPos])) {
					rightPos--;
				}
				
				if(leftPos == rightPos) {
					break;
				}
				char aux = current[rightPos];
				current[rightPos] = current[leftPos];
				current[leftPos] = aux;
				leftPos++;
				rightPos--;
			}
			System.out.println(current);
			
		}
		
	}
	
	static boolean isSpecialCharacter(char character) {
		return !((character >= 'a' && character <= 'z')
				|| (character >= 'A' && character <= 'Z')
				|| (character >= '0' && character <= '9'));
	}
	
}