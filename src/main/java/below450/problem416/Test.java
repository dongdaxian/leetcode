package below450.problem416;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		

	}
	
	public boolean canPartition(int[] nums) {
		int sum = 0;
		Arrays.sort(nums);
		for(int i: nums)
			sum += i;
		if(sum % 2 == 1)
			return false;
		return canPartition(nums, 0, 0, sum / 2);
    }
	//回溯会重复计算，比如 beg = 4 sum = 10时，sum有多种组合可能，所以当该函数返回false时就会被调用多次 
	public boolean canPartition(int[] nums, int beg, int sum, int halfSum) {
		if(sum > halfSum || beg == nums.length)
			return false;
		else if(sum == halfSum)
			return true;
		return canPartition(nums, beg + 1, sum + nums[beg], halfSum) || canPartition(nums, beg + 1, sum, halfSum);
	}
	
	public boolean canPartition2(int[] nums) {
		int sum = 0;
		Arrays.sort(nums);
		for(int i: nums)
			sum += i;
		if(sum % 2 == 1 || nums.length < 2)
			return false;
		sum = sum / 2;
		boolean[][] canPar = new boolean[nums.length + 1][sum + 1]; 
		for(int i = 0; i < nums.length + 1; i++) {
			canPar[i][0] = true;
		}
		//此处，i + 1对应着index为i，j对应着和为j，最终的canPar[nums.length][sum]对应index为nums.length-1，和为sum
		for(int i = 0; i < nums.length; i++)
			for(int j = 1; j < sum + 1; j++) {
				if(j < nums[i]) {
					canPar[i + 1][j] = canPar[i][j];
					continue;
				}
				canPar[i + 1][j] = canPar[i][j] || canPar[i][j - nums[i]];
			}
		return canPar[nums.length][sum];
    }
	

}
