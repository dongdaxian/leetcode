package below50.problem45;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().jump1(new int[]{2,3,1,1,4}));

	}
	
	public int jump1(int[] nums) {
		int n = nums.length;
		int[] step = new int[n];
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= nums[i] && i + j < n; j++) {
				if(step[i + j] == 0 || step[i + j] > step[i] + 1)
					step[i + j] = step[i] + 1;
			}
		}
		return step[n - 1];
    }
	
	public int jump2(int[] A) {									//注意，这仍是dp，不是贪心
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}

}
