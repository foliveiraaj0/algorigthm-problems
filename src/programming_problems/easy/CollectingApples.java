package programming_problems.easy;

public class CollectingApples {

	public static void main(String[] args) {
		int[] A = new int[] {6,1,4,6,3,2,7,4};
		int K = 3;
		int L = 2;
		//expect 24;
		
		System.out.println(solution(A, K, L));
	}
	
	public static int solution(int[] A, int K, int L) {
        
        int max = -1;
        
        if(A.length < K+L ) {
        	return max;
        }
        
        int kPrioritySum = calculateMaxSum(A, K, L);
        int lPrioritySum = calculateMaxSum(A, L, K);
        
        max = kPrioritySum > lPrioritySum ? kPrioritySum : lPrioritySum;
        
		return max;
    }
	
	static int calculateMaxSum (int[] A, int K, int L) {
		int currentSum = 0;
		for(int leftK=0,rightK=K-1;rightK<A.length;leftK++,rightK++) {
        	int k = leftK, kSum=0;
        	while(k <= rightK) {
        		kSum += A[k];
        		k++;
        	}
        	for(int leftL=0,rightL=L-1;rightL<A.length;leftL++,rightL++) {
            	if(rightL < leftK || leftL > rightK) {
            		int l = leftL, lSum=0;
            		while(l<=rightL) {
            			lSum += A[l];
            			l++;
            		}
            		if(currentSum < kSum+lSum) {
            			currentSum = kSum+lSum;
            		}
            	}
            }
        }
		return currentSum;
	}

}
