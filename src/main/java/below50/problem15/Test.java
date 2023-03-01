package below50.problem15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int[] nums = {-6, 3, 3, 3, 3};
        List<List<Integer>> ls = new Test().threeSum1(nums);
        for (List<Integer> l : ls) {
            for (Integer x : l) {
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new LinkedList<>();
        int target;
        int beg, end;
        for (int i = 0; i < nums.length; i++) {
//	        while(i > 0 && i < nums.length && nums[i] == nums[i - 1]) i++;  
            if (i > 0 && nums[i] == nums[i - 1]) continue;                    //借助外层循环不嵌套for/while的做法
            beg = i + 1;
            end = nums.length - 1;
            target = -nums[i];
            while (beg < end) {
                if (beg > i + 1 && nums[beg] == nums[beg - 1]) {              //同上
                    beg++;
                    continue;
                }
                if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }

//                while (beg > i + 1 && beg < end && nums[beg] == nums[beg - 1]) {
//                    beg++;
//                }
//                while (end < nums.length - 1 && beg < end && nums[end] == nums[end + 1]) {
//                    end--;
//                }
//                if (beg >= end) {
//                    break;
//                }

                if (nums[beg] + nums[end] < target) {
                    beg++;
                } else if (nums[beg] + nums[end] > target) {
                    end--;
                } else {
                    ls.add(Arrays.asList(nums[i], nums[beg], nums[end]));
                    beg++;
                    end--;
                }
            }

        }
        return ls;
    }


    public List<List<Integer>> threeSum2(int[] nums) {      //使用HashSet的做法，相当于做了n次2Sum问题
        Arrays.sort(nums);
        List<List<Integer>> ls = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(nums[j])) {
                    ls.add(Arrays.asList(nums[i], target - nums[j], nums[j]));
                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;      // i 也可以像这样放到后面来处理
                } else
                    set.add(target - nums[j]);

            }
            set.clear();
        }
        return ls;
    }


}
