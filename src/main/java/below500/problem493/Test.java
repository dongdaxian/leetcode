package below500.problem493;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
	public static void main(String[] args) {
		System.out.println(new Test().reversePairs2(new int[] {2, 4 ,3 ,5, 1}));
	}
	
	
	public int reversePairs(int[] nums) {
		List<Long> ls = new ArrayList<>();
		int res = 0;
		for(int i = nums.length - 1; i > -1; i--) {
			res += searchAndInsert(ls, nums[i]);
		}
		return res;
    }
	
	public int searchAndInsert(List<Long> ls, int target) {
		long tarNum = (long)target;
		if(ls.size() == 0) {
			ls.add(tarNum * 2);
			return 0;
		}
		//查找部分
		int size = ls.size();
		int left = 0, right = ls.size() - 1;
		int res = 0;
		while(left < right) {
			int mid = (left + right) / 2;
			if(ls.get(mid) < tarNum) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		if(ls.get(left) >= tarNum)
			res = left;
		else
			res = left + 1;
		//插入部分
		tarNum = tarNum * 2;
		left = 0;
		right = ls.size() - 1;
		while(left < right) {
			int mid = (left + right) / 2;
			if(ls.get(mid) < tarNum) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		if(ls.get(left) > tarNum)
			ls.add(left, tarNum);
		else
			ls.add(left + 1, tarNum);
		
		return res;
	}
	
	//归并的做法
	public int reversePairs2(int[] nums) {
		if(nums.length == 0)
			return 0;
		return reversePairsRecursive(nums, 0, nums.length - 1);
	}
	public int reversePairsRecursive(int[] nums, int left, int right) {
		if(left == right)
			return 0;
		int res = 0;
		int mid = (left + right) / 2;
		res += reversePairsRecursive(nums, left, mid);
		res += reversePairsRecursive(nums, mid + 1, right);
		int rptr = mid + 1;
		int lptr = left;
		while(rptr <= right) {
			while(lptr < mid + 1 && (long)nums[rptr] * 2 < (long)nums[lptr]) {
				lptr++;
			}
			res += lptr - left;
			rptr++;
		}
		
		int[] sorted = new int[right - left + 1];
		lptr = left;
		rptr = mid + 1;
		int ptr = 0;
		while(lptr < mid + 1 && rptr <= right) {
			if(nums[lptr] < nums[rptr])
				sorted[ptr++] = nums[rptr++];
			else
				sorted[ptr++] = nums[lptr++];
		}
		while(lptr < mid + 1) {
			sorted[ptr++] = nums[lptr++];
		}
		while(rptr <= right) {
			sorted[ptr++] = nums[rptr++];
		}
		for(int i = 0; i < sorted.length; i++)
			nums[left + i] = sorted[i];
		return res;
	}
	
}
