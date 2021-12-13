package below100.problem51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<List<String>> res = new Test().solveNQueens(4);
		for(List<String> l: res) {
			for(String temp: l)
				System.out.println(temp);
			System.out.println();
		}

	}
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		backTrack(new ArrayList<Integer>(), res, n);
		return res;
    }

	public void backTrack(ArrayList<Integer> curls, List<List<String>> res, int n) {
		if(curls.size() == n) {
			List<String> tem = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				char[] temp = new char[n];
				Arrays.fill(temp, '.');
				temp[curls.get(i)] = 'Q';
				tem.add(new String(temp));
			}
			res.add(tem);
//			curls.remove(n - 1);
		} else {
			for(int col = 0; col < n; col++) {
				if(!curls.contains(col)) {
					curls.add(col);
					if(isValid(curls))
						backTrack(curls, res, n);
					curls.remove(curls.size() - 1);
				}
			}
		}
		
	}
	
	public boolean isValid(ArrayList<Integer> curls)
	{
		int row = curls.size() - 1;
		int col = curls.get(row);
		int i = 0;
		for(i = 0; i < row && (row - i) != Math.abs(col - curls.get(i)); i++);
		if(i == row)
			return true;
		return false;
	}

}
