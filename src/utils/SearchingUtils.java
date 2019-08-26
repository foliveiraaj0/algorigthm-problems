package utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class SearchingUtils {

	public static boolean binarySearch(int[] data, int target) {
		int lo = 0, hi = data.length-1;
		while(lo <= hi) {
			int mid = (hi-lo)/2 + lo;
			if(data[mid] < target) {
				lo = mid+1;
			}
			else if (data[mid] > target){
				hi = mid-1;
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	@Test
	void testBinarySearch() {
		assertFalse(SearchingUtils.binarySearch(new int[] {}, 4));
		assertTrue(SearchingUtils.binarySearch(new int[] {1,2,5,8,10,50,600,1850}, 2));
		assertTrue(SearchingUtils.binarySearch(new int[] {1,2,5,8,10,50,600,1850}, 1850));
		assertFalse(SearchingUtils.binarySearch(new int[] {1,2,5,8,10,50,600,1850}, 49));
		assertFalse(SearchingUtils.binarySearch(new int[] {1,2,5,8,10,50,600,1850}, 2000));
	}
	
}
