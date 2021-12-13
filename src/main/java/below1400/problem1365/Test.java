package below1400.problem1365;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] temp = Arrays.copyOf(nums, nums.length);
		int[] res = new int[nums.length];
		Arrays.sort(temp);
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < temp.length; i++) {
			if(!map.containsKey(temp[i]))
				map.put(temp[i], i);
		}
		for(int i = 0; i < nums.length; i++)
			res[i] = map.get(nums[i]);
		return res;
    }
}
