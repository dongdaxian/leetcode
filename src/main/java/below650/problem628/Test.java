package below650.problem628;

import java.util.Arrays;

public class Test {
	
	
	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		if(nums[n - 1] >= 0) {
			return nums[n - 1] * Integer.max(nums[0] * nums[1], nums[n - 3] * nums[n - 2]);
		}
		return nums[n - 3] * nums[n - 2] * nums[n - 1];
    }
}