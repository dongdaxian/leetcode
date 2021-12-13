package below200.problem164;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		
	}
	
	
//	基数排序
	public int maximumGap(int[] nums) {
		int n = nums.length;
		int[] buf = new int[n];
//		如果是int型，可能会在while中一直循环下去
		long exp = 1;
		int maxNum = Integer.MIN_VALUE;
		for(int temp: nums)
			maxNum = Integer.max(maxNum, temp);
//		用的不是标准先分配再收集的方法。直接确定了元素下一次收集后的位置，相当于省去了分配这一步
		while(exp < maxNum) {
			int[] cnt = new int[10];
			for(int i = 0; i < n; i++) {
				int digit = (nums[i] / (int)exp) % 10;
				cnt[digit]++;
			}
			for(int i = 1; i < 10; i++)
				cnt[i] += cnt[i - 1];
			for(int i = n - 1; i > -1; i--) {
				int digit = (nums[i] / (int)exp) % 10;
				buf[cnt[digit] - 1] = nums[i];
				cnt[digit]--;
			}
			exp *= 10;
			System.arraycopy(buf, 0, nums, 0, n);
		}
//		基数排序结束
		int maxGap = 0;
		for(int i = 1; i < n; i++) {
			maxGap = Integer.max(maxGap, nums[i] - nums[i - 1]);
		}
		return maxGap;
    }

//	桶排序
	public int maximumGap2(int[] nums) {
		int n = nums.length;
		if(n < 2)
			return 0;
		int maxVal = Arrays.stream(nums).max().getAsInt();
		int minVal = Arrays.stream(nums).min().getAsInt();
		int interval = Integer.max(1, (maxVal - minVal) / (n - 1));
		int bucketSize = (maxVal - minVal) / interval + 1;	//不一定等于n
//		只要maxVal!=minVal，那么bucketSize>=2，那么最小值最大值肯定会被放入不同的两个桶中，即一定有结果
		int[][] bucket = new int[bucketSize][2];
		for(int[] temp: bucket) {
			temp[0] = Integer.MAX_VALUE;
			temp[1] = -1;
		}
		for(int i = 0; i < n; i++) {
			int ind = (nums[i] - minVal) / interval;
			bucket[ind][0] = Integer.min(bucket[ind][0], nums[i]);
			bucket[ind][1] = Integer.max(bucket[ind][1], nums[i]);
		}
		int ret = 0;
		int pre = -1;
		for(int i = 0; i < bucketSize; i++) {
			if(bucket[i][1] == -1)
				continue;
			if(pre != -1) {
				ret = Integer.max(ret, bucket[i][0] - bucket[pre][1]);
			}
			pre = i;
		}
		return ret;
	}

}
