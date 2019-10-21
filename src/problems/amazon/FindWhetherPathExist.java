package problems.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import utils.ArrayUtils;

public class FindWhetherPathExist {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String tString = "";
		try {
			tString = reader.readLine();
		} catch (IOException e) {
		}

		int T = Integer.parseInt(tString);
		
		for (int i = 0; i < T; i++) {
			String nString = "";
			try {
				nString = reader.readLine();
			} catch (IOException e) {
			}
			
			int N = Integer.parseInt(nString);
			
			int[][] m = new int[N][N];
			
			String row = "";
			try {
				row = reader.readLine().trim().replace(" ", "");
			} catch (IOException e) {
			}
			
			ArrayUtils.fillMatrix(row, m);
			
			System.out.println(hasPath(m, new int[] {0,1}));
		}
	}
	
	static int hasPath(int[][] m, int[] forbidenValues) {
		
		int[] s = findSource(m);
		
		Stack<int[]> path = new Stack<int[]>(); 
		
		path.push(s);
		
		int[] move = null;
		
		while(!path.empty()) {
			int[] pos = path.pop();
			
			if(hasFoundDestiny(pos, m)) {
				path.clear();
				return 1;
			}
			
			move = ArrayUtils.goLeft(pos, m, forbidenValues);
			if(move != null) {
				path.push(move);
			}
			
			move = ArrayUtils.goRight(pos, m, forbidenValues);
			if(move != null) {
				path.push(move);
			}
			
			move = ArrayUtils.goUp(pos, m, forbidenValues);
			if(move != null) {
				path.push(move);
			}
			
			move = ArrayUtils.goDown(pos, m, forbidenValues);
			if(move != null) {
				path.push(move);
			}
			
			m[pos[0]][pos[1]] = 0;
		}
		
		return 0;
	}
	
	static boolean hasFoundDestiny(int[] pos, int[][] m) {
		return m[pos[0]][pos[1]] == 2;
	}
	
	static int[] findSource(int[][]m) {
		int[] s = new int[2];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if(m[i][j] == 1) {
					s[0] = i;
					s[1] = j;
					return s;
				}
			}
		}
		return s;
	}
	
}

