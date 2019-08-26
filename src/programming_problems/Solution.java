package programming_problems;

import java.util.List;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {

		int maxDist = 0;
		
		List<List<Integer>> allFowarded = copy(forwardRouteList);
		
		while(!allFowarded.isEmpty()) {
			List<Integer> current = allFowarded.remove(0);
		}
		
		return null;
	}
	
	List<List<Integer>> copy(List<List<Integer>> route) {
		return route;
	}

	int getTotalDist(List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {
		return 0;
	}
	
	List<List<Integer>> findBestPathBack(int idStart, List<List<Integer>> returnRouteList) {
		return null;
	}
}