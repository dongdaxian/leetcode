package below750.problem724;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Object> ls = new ArrayList<Object>();
    }

    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int befSum = 0;
        int behSum = Arrays.stream(nums).skip(1).sum();
        int i = 0;
        for(; i < nums.length - 1 && befSum != behSum; i++) {
            befSum += nums[i];
            behSum -= nums[i + 1];
        }
        if(befSum == behSum)
            return i;
        return -1;
    }
    public int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
