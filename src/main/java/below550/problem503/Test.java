package below550.problem503;

import java.util.Arrays;
import java.util.Stack;

public class Test {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0)
            return new int[0];
        int n = nums.length;
        boolean[] ifUsed = new boolean[n];
        int[] ret = new int[n];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxRecord = Integer.MIN_VALUE;
        while(!ifUsed[i] || !stack.isEmpty()) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                ret[stack.pop()] = nums[i];
            }
            if(!ifUsed[i]) {
                stack.add(i);
                ifUsed[i] = true;
                maxRecord = Integer.max(maxRecord, nums[i]);
            } else {
                if(!stack.isEmpty() && nums[stack.peek()] == maxRecord) {
                    ret[stack.pop()] = -1;
                }
            }
            i = (i + 1) % n;
        }
        return ret;
    }


    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }



}
