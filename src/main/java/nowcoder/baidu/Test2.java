package nowcoder.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<Integer> rightLs = new ArrayList<>();
        List<Integer> errorLs = new ArrayList<>();
        boolean flag = (k % 2 == 0);
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                if (flag) {
                    rightLs.add(nums[i]);
                } else {
                    errorLs.add(nums[i]);
                }
            } else {
                if (!flag) {
                    rightLs.add(nums[i]);
                } else {
                    errorLs.add(nums[i]);
                }
            }
        }
        int i = 0;
        int size = Math.min(rightLs.size(), errorLs.size());
        List<int[]> res = new ArrayList<>();
        while (i < size) {
            res.add(new int[] {rightLs.get(i), errorLs.get(i)});
            i++;
        }
        if (rightLs.size() - errorLs.size() > 0) {
            while (i + 1 < rightLs.size()) {
                res.add(new int[]{rightLs.get(i), rightLs.get(i + 1)});
                i += 2;
            }
        }
        System.out.println(res.size());
        for (int j = 0; j < res.size(); j++) {
            System.out.println(res.get(j)[0] + " " + res.get(j)[1]);
        }
    }
}
