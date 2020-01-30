package problems.amazon;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import utils.ArrayUtils;

public class ConstructTreeFromPreorderTraversal {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String TString = "";
		try {
			TString = reader.readLine();
		} catch (IOException e) {
		}

		int T = Integer.parseInt(TString);
		for (int i = 0; i < T; i++) {
			String nString = "";
			try {
				nString = reader.readLine();
			} catch (IOException e) {
			}

			int N = Integer.parseInt(nString);

			String preString = "";
			try {
				preString = reader.readLine().trim();
			} catch (IOException e) {
			}

			List<Integer> pre = new ArrayList<Integer>();

			fillValues(pre, preString, new IntegerParser());

			String prelnString = "";
			try {
				prelnString = reader.readLine().trim();
			} catch (IOException e) {
			}

			List<Character> preln = new ArrayList<Character>();

			fillValues(preln, prelnString, new CharacaterParser());

			Node tree = constructTree(N, ArrayUtils.toIntArray(pre), ArrayUtils.toCharArray(preln));

			print(tree);

		}

	}

	static <T> void fillValues(List<T> list, String tString, Parser<T> parser) {

		int nextSpace = tString.indexOf(" ");

		while (nextSpace != -1) {
			String valueString = tString.substring(0, nextSpace);
			list.add(parser.parse(valueString));
			tString = tString.substring(nextSpace + 1);
			nextSpace = tString.indexOf(" ");
		}
		list.add(parser.parse(tString));

	}

	static Node constructTree(int n, int pre[], char preLN[]) {
		if (n == 0) {
			return null;
		}

		int index = pre.length - n;
		Node current = new Node(pre[index]);
		int leftSize = 0;
		if (preLN[index] == 'N') {
			current.left = constructTree(n - 1, pre, preLN);
			leftSize = getSize(n - 1, preLN);
			current.right = constructTree(n - leftSize - 1, pre, preLN);
		}

		return current;

	}

	static int getSize(int n, char[] preLN) {
		int index = preLN.length - n;
		int leftSize = 0, rightSize = 0;
		
		if (preLN[index] == 'N') {
			leftSize = getSize(n - 1, preLN);
			rightSize = getSize(n - leftSize - 1, preLN);
		}
		return leftSize + rightSize + 1;
	}

	static void print(Node root) {
		if (root.left != null) {
			print(root.left);
		}
		System.out.printf("%d", root.data);
		if (root.right != null) {
			print(root.right);
		}
	}

	interface Parser<T> {
		T parse(String sValue);
	}

	static class IntegerParser implements Parser<Integer> {

		@Override
		public Integer parse(String sValue) {
			return Integer.parseInt(sValue);
		}

	}

	static class CharacaterParser implements Parser<Character> {

		@Override
		public Character parse(String sValue) {
			return sValue.charAt(0);
		}

	}

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	@Test
	void testAddValue() {
		List<Integer> intList = new ArrayList<Integer>();
		fillValues(intList, "1 2 3", new IntegerParser());
		assertTrue(intList.size() == 3);
		assertTrue(intList.contains(1));
		assertTrue(intList.contains(3));
		assertFalse(intList.contains(0));
	}

	@Test
	void testConstructTree() {
		Node tree = constructTree(5, new int[] { 10, 30, 20, 5, 15 }, new char[] { 'N', 'N', 'L', 'L', 'L' });
		assertTrue(tree.data == 10);
		assertTrue(tree.left.right.data == 5);
		assertTrue(tree.right.data == 15);
	}

	@Test
	void testSubmission() {
		Node tree = constructTree(7, new int[] { 0, 1, 3, 4, 2, 5, 6 },
				new char[] { 'N', 'N', 'L', 'L', 'N', 'L', 'L' });
		assertTrue(tree.data == 0);
		assertTrue(tree.right.data == 2);
		assertTrue(tree.left.right.data == 4);
		assertTrue(tree.right.left.data == 5);
	}
}
