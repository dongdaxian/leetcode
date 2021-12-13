package below200.problem189;

import java.util.stream.IntStream;

public class Test {
	public static void main(String[] args) {
		
	}
	
	//流中没有下标，所以不能用Stream
	public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0)  return;
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        
        //翻转方式2
//        reverse(nums, 0, nums.length - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, nums.length - 1);
        
    }
	
	//也可以while(beg < end)
    public void reverse(int[] nums, int beg, int end) {
        int mid = (end - beg + 1) / 2;
        for(int i = 0; i < mid; i++) {
            int temp = nums[beg + i];
            nums[beg + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }
}
