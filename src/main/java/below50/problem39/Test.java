package below50.problem39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jdk.nashorn.internal.runtime.regexp.joni.ast.CClassNode;

public class Test {
	public static void main(String[] args) {
		int[] candidates = new int[] {2,3,5};
		List<List<Integer>> res = new Test().combinationSum(candidates, 8);
		for(List<Integer> ls: res) {
			for(int temp: ls)
				System.out.print(temp + " ");
			System.out.println();
		}
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		List<Integer> ls = new ArrayList<>();
		combine(res, ls, candidates, 0, target);
		return res;
    }
	
	public void combine(List<List<Integer>> res, List<Integer> ls, int[] candidates, int beg, int target) {
		if (target == 0)
			res.add(new ArrayList<>(ls));
		else if (beg < candidates.length) {
			combine(res, ls, candidates, beg + 1, target);
			if (candidates[beg] <= target) {
				int temp = candidates[beg];
				ls.add(temp);
				combine(res, ls, candidates, beg, target - temp);
				ls.remove(ls.size() - 1);
			}
		}
	}
//	方法一更合逻辑
	public void combine2(List<List<Integer>> res, List<Integer> ls, int[] candidates, int beg, int target) {
		if(target == 0)
			res.add(new ArrayList<>(ls));
		else
			for(int i = beg; i < candidates.length && candidates[i] <= target; i++) {
				int temp = candidates[i];
				ls.add(temp);
				combine2(res, ls, candidates, i, target - temp);
				ls.remove(ls.size() - 1);
			}
	}

}
