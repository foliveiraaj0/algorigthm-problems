package programming_problems.easy;

public class Seasons {

	public static void main(String[] args) {
			int[] T = new int[] {-3, -14, -5, 7, 8, 42, 8, 3};
	        int seasons = 4;
	        int amplitudes = T.length/seasons;
	        System.out.printf("amplitudes %d\n", amplitudes);
	        int higherAmp=Integer.MIN_VALUE;
	        String[] seasonNames = new String[]{"WINTER", "SPRING", "SUMMER", "AUTUMN"};
	        String solution = "";
	        for(int s=0; s<seasons;s++) {
	            int lower = T[s*amplitudes];
	            int higher = T[s*amplitudes];
	            System.out.printf("lower %d\n", lower);
	            System.out.printf("higher %d\n", higher);
	            
	            for(int a=0;a<amplitudes;a++) {
	                int currentAmp = T[s*amplitudes+a];
	                System.out.printf("currrentAmp %d\n", currentAmp);
	                if(currentAmp < lower) {
	                    lower = currentAmp;
	                }
	                if(currentAmp > higher) {
	                    higher = currentAmp;
	                }
	            }
	            
	            int amp = higher - lower;
	            System.out.printf("amp %d\n", amp);
	            
	            if(s == 0) {
	                higher = amp;
	                solution = seasonNames[0];
	            }
	            else if(amp > higherAmp){
	            	higherAmp = amp;
	                solution = seasonNames[s];
	            }
	        }
	        System.out.println(solution); 
	        
	    }

	

}
