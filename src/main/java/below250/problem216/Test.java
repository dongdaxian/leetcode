package below250.problem216;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<List<Integer>> res = new Test().combinationSum3(3, 9);
		for(List<Integer> ls: res) {
			for(int temp: ls)
				System.out.print(temp + " ");
			System.out.println();
		}
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> ls = new ArrayList<>();
		combine(res, ls, k, n, 1);
		return res;
    }
	
	public void combine(List<List<Integer>> res, List<Integer> ls, int leftK, int leftN, int beg) {
		if(leftK == 0 && leftN == 0)
			res.add(new ArrayList<>(ls));
		else if(leftK == 0 || leftN == 0)
			return;
		for(int i = beg; i < 10 && i <= leftN; i++) {
			ls.add(i);
			combine(res, ls, leftK - 1, leftN - i, i + 1);
			ls.remove(ls.size() - 1);
		}
	}
	
}
