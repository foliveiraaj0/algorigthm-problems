package problems.amazon;

public class OccurencesOf2sAsADigit {

	public static void main(String[] args) {
		int n = 10*10*10*10*10;
		System.out.println((new GfG().count2s(n)));
	}
	
	static class GfG
	{
	    public long count2s(long n)
	    {
	    	long ans = 0;
			for (long i = 0; i <= n; i++) {
				ans += (""+i).replaceAll("[^2]", "").length();
			}
			return ans;
	    }
	    
	    public long count2sinRangeAtDigit(long n, long d)
	    {
	    	long ans = 0;
			for (long i = n; i <= d; i++) {
				ans += (""+i).replaceAll("[^2]", "").length();
			}
			return ans;
	    }
	}
	
}
