package below100.problem78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<List<Integer>> res = new Test().subsets(new int[]{1, 2, 3});
		System.out.println(res.size());
		for(List<Integer> ls: res) {
			for(int i: ls)
				System.out.print(i);
			System.out.println();
		}

	}
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		if(nums.length == 0) return res;
		getRes(res, new ArrayList<Integer>(), 0, nums);
		return res;
    }
	public void getRes(List<List<Integer>> res, List<Integer> list, int k, int[] nums) {
		if(k == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
//		for(int i = k; i < nums.length; i++) {}			//当要区分排列顺序时，就需要用for
		list.add(nums[k]);
		getRes(res, list, k + 1, nums);
		list.remove(list.size() - 1);
		getRes(res, list, k + 1, nums);
	}
	
	
}
