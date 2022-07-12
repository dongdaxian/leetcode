package below50.problem18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1, right = nums.length - 1;
                int tempTarget = target - nums[i] - nums[j];
                while (left < right) {
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        ++left;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        --right;
                        continue;
                    }

                    if (nums[left] + nums[right] == tempTarget) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        ++left;
                        --right;
                    } else if (nums[left] + nums[right] < tempTarget) {
                        ++left;
                    } else {
                        --right;
                    }
                }
            }
        }
        return res;
    }
}
