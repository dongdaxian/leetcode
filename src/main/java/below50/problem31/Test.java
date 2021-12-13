package below50.problem31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	
	
	public void nextPermutation(int[] nums) {
		List<Integer> queue = new ArrayList<>();
		int i = nums.length - 2;
		queue.add(nums[nums.length - 1]);
		for(; i > -1 && nums[i] > nums[i + 1]; i--) {
			queue.add(nums[i]);
		}
//		queue.add(nums[i]);
		Collections.sort(queue);
		int j = i + 1;
		boolean flag = false;
		for(int temp: queue) {
			if(!flag && temp > nums[i])
				nums[i] = temp;
			else
				nums[j++] = temp;
		}
    }
}
