package below350.problem300;

import javafx.util.Pair;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        System.out.print(new Test().lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18}));
    }

    /*
    * 序列13 12 1 9 10 2 3 4
    * 遍历到12时，肯定可以排除掉以13开头的子序列
    * 遍历到2时，并不能确定最终结果是1 9 10 *还是1 2 *。能确定的话时间复杂度就是O(n)了
    * */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }


    public int lengthOfLIS2(int[] nums) {
        int ptr = 0;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res[ptr]) {
                res[++ptr] = nums[i];
            } else if (nums[i] < res[ptr]) {
                int left = 0;
                int right = ptr;
                int index = binarySearch(res, left, right, nums[i]);
                res[index] = nums[i];
            }
        }
        return ptr + 1;
    }

    public int binarySearch(int[] res, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > res[mid]) {
                left = mid + 1;
            } else if (target < res[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

}
