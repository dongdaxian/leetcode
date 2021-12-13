package below50.problem16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		
	}
	
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int cloestNum = Integer.MIN_VALUE / 2;
		for(int i = 0; i < nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i - 1])
				continue;
			int tempTarget = target - nums[i];
			int j = i + 1;
			int k = nums.length - 1;
			while(j < k) {
				cloestNum = Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(cloestNum - target) ? nums[i] + nums[j] + nums[k] : cloestNum;
				if(nums[j] + nums[k] < tempTarget) {
					j++;
				} else if(nums[j] + nums[k] > tempTarget) {
					k--;
				} else {
					return target;
				}
			}
		}
		return cloestNum;
    }
}
