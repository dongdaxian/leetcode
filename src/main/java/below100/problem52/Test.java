package below100.problem52;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().totalNQueens(4));
	}
	
	public int totalNQueens(int n) {
		return backtrack(new ArrayList<Integer>(), n);
    }
	
	//也可以改成无返回值，使用一个全局变量记录
	public int backtrack(List<Integer> ls, int n) {
		if(ls.size() == n)
			return 1;
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(!ls.contains(i)) {
				ls.add(i);
				if(isValid(ls))
					count += backtrack(ls, n);
				ls.remove(ls.size() - 1);
			}
		}
		return count;
	}

	public boolean isValid(List<Integer> ls) {
		int row = ls.size() - 1;
		int col = ls.get(row);
		int i = 0;
		for(i = 0; i < row && (row - i) != Math.abs(col - ls.get(i)); i++);
		if(i == row)
			return true;
		return false;
	}

}
