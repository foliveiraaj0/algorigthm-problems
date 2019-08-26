package utils;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ArrayUtils {

	public static int[] toIntArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
	
	public static char[] toCharArray(List<Character> list) {
		char[] ret = new char[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
	
	@Test
	void testToIntArray() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(3);
		int[] arr = toIntArray(list);
		assertTrue(arr.length == list.size());
		assertTrue(arr[2] == 3);
		
	}
	
	@Test
	void tesetToCharArray() {
		List<Character> list = new ArrayList<Character>();
		list.add('e');
		list.add('b');
		list.add('q');
		char[] arr = toCharArray(list);
		assertTrue(arr.length == list.size());
		assertTrue(arr[1] == 'b');
	}
}
