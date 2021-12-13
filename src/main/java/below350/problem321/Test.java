package below350.problem321;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		int[] res = new Test().maxNumber(new int[] {9,  1,  2, 5, 8, 3}, new int[] {3, 4, 6, 5}, 5);
		for(int temp: res)
			System.out.print(temp + " ");
	}
	//这道题重点在于，从nums1中取两个数组成最后的结果，这个两位数一定是nums1能形成的最大的，即402题
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int minusSize = nums1.length + nums2.length - k;
        for(int minusSize1 = 0; minusSize1 <= minusSize; minusSize1++){
            int minusSize2 = minusSize - minusSize1;
            if(minusSize1 > nums1.length || minusSize2 > nums2.length)
                continue;
            int[] res1 = getStack(nums1, minusSize1);
            int[] res2 = getStack(nums2, minusSize2);
            int[] temp = merge(res1, res2);
            if(doCompare(res, temp, 0, 0) < 0) {
            	res = temp;
            }
        }
        return res;
    }
    public int[] getStack(int[] nums, int k){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length - k];
        int ptr = res.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(stack.isEmpty() || stack.peek() >= nums[i] || k == 0){
                stack.push(nums[i]);
            } else {
                stack.pop();
                i--;
                k--;
            }
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()){
            res[ptr--] = stack.pop();
        }
        return res;
    }
    public int[] merge(int[] res1, int[] res2){
        int[] res = new int[res1.length + res2.length];
        int ptr1 = 0, ptr2 = 0;
        for(int i = 0; i < res.length; i++) {
        	if(doCompare(res1, res2, ptr1, ptr2) > 0)
        		res[i] = res1[ptr1++];
        	else
        		res[i] = res2[ptr2++];
        }
        return res;
    }
    public int doCompare(int[] nums1, int[] nums2, int index1, int index2){
        int ptr = 0;
        while(index1 < nums1.length && index2 < nums2.length){
        	int difference = nums1[index1] - nums2[index2];
        	if(difference != 0)
        		return difference;
        	index1++;
        	index2++;
        }
        return nums1.length - index1 - nums2.length + index2;
    }
	
}
