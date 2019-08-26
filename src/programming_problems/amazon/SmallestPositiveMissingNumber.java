package programming_problems.amazon;

import utils.SortingUtils;

public class SmallestPositiveMissingNumber {

	public static void main(String[] args) {
		int[] arr = new int[] {13,3,10,1,2,5,6};
		
		int data[] = SortingUtils.sortByTree(arr);
		
		System.out.println(searchLowerMissing(data));
	}
	
	static int searchLowerMissing(int[] data) {
		int lower = 0;
		int lo = 0, hi = data.length -1;
		if(data[hi] == data.length) {
			return data[hi] + 1;
		}
		else {
			while(lo <= hi) {
				int mid = (hi-lo)/2 + lo;
				if(data[mid] == mid+1) {
					lo = mid+1;
					lower = data[mid];
				}
				else {
					hi = mid-1;
				}
			}
		}
		return lower + 1;
	}
}

