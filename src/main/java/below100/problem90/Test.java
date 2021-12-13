package below100.problem90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, nums, 0, new ArrayList<>());
        return ret;
    }

    public void dfs(List<List<Integer>> ret, int[] nums, int index, List<Integer> ls) {
        if (index == nums.length) {
            ret.add(new ArrayList<>(ls));
        } else {
            int i = index + 1;
            for(; i < nums.length && nums[i] == nums[index]; i++);
            dfs(ret, nums, i, ls);
            ls.add(nums[index]);
            dfs(ret, nums, index + 1, ls);
            ls.remove(ls.size() - 1);
        }

    }

}
