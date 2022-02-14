package below50.problem47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        for (List<Integer> ls : new Test().permuteUnique(new int[]{1, 1, 2, 2})) {
            for (int i : ls)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        backtrack_choose(res, ls, nums, visit);
        return res;
    }

    public void backtrack_choose(List<List<Integer>> res, List<Integer> ls, int[] nums, boolean[] visit) {
        if (ls.size() == nums.length) {
            res.add(new ArrayList<>(ls));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]))    //当出现visit[i - 1]为false，说明这两个相同元素已经以原顺序遍历过了
                continue;
            ls.add(nums[i]);
            visit[i] = true;
            backtrack_choose(res, ls, nums, visit);
            visit[i] = false;
            ls.remove(ls.size() - 1);
        }
    }


}
