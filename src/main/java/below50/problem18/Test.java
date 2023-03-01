package below50.problem18;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        List<List<Integer>> res = new Test().fourSum2(new int[] {1000000000,1000000000,1000000000,1000000000}, -294967296);
        List<List<Integer>> res = new Test().fourSum2(new int[] {1,0,-1,0,-2,2}, 0);

        System.out.println(res.size());
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
                long tempTarget = (long)target - nums[i] - nums[j];
                while (left < right) {
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        ++left;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        --right;
                        continue;
                    }

                    if ((long)nums[left] + nums[right] == tempTarget) {
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

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            while (i > 0 && i < nums.length - 3 && nums[i] == nums[i - 1]) {
                i++;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                while (j > i + 1 && j < nums.length - 2 && nums[j] == nums[j - 1]) {
                    j++;
                }
                long sum = (long)target - (nums[i] + nums[j]);
                Set<Long> set = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    if (set.contains((long)nums[k])) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(target - nums[i] - nums[j] - nums[k]);
                        res.add(temp);
                        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                            k++;
                        }
                    } else {
                        set.add(sum - nums[k]);
                    }
                }
            }
        }


        return res;
    }
}
