package utils;

import utils.data_structures.Tree;

public class SortingUtils {

	public static int[] sortByMergeSort(int[] data) {
		return null;
	}

	public static int[] sortByTree(int[] data) {
		Tree t = new Tree();
		for (int i = 0; i < data.length; i++) {
			t.add(data[i]);
		}
		return t.readData();
	}

}
