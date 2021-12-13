package below200.problem164;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		
	}
	
	
//	��������
	public int maximumGap(int[] nums) {
		int n = nums.length;
		int[] buf = new int[n];
//		�����int�ͣ����ܻ���while��һֱѭ����ȥ
		long exp = 1;
		int maxNum = Integer.MIN_VALUE;
		for(int temp: nums)
			maxNum = Integer.max(maxNum, temp);
//		�õĲ��Ǳ�׼�ȷ������ռ��ķ�����ֱ��ȷ����Ԫ����һ���ռ����λ�ã��൱��ʡȥ�˷�����һ��
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
//		�����������
		int maxGap = 0;
		for(int i = 1; i < n; i++) {
			maxGap = Integer.max(maxGap, nums[i] - nums[i - 1]);
		}
		return maxGap;
    }

//	Ͱ����
	public int maximumGap2(int[] nums) {
		int n = nums.length;
		if(n < 2)
			return 0;
		int maxVal = Arrays.stream(nums).max().getAsInt();
		int minVal = Arrays.stream(nums).min().getAsInt();
		int interval = Integer.max(1, (maxVal - minVal) / (n - 1));
		int bucketSize = (maxVal - minVal) / interval + 1;	//��һ������n
//		ֻҪmaxVal!=minVal����ôbucketSize>=2����ô��Сֵ���ֵ�϶��ᱻ���벻ͬ������Ͱ�У���һ���н��
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
