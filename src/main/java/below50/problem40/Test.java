package below50.problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,2,5};
        List<List<Integer>> res = new Test().combinationSum2(arr, 5);
        res.forEach(itt -> itt.forEach(System.out::println));
        //for (List<Integer> ls : res) {
        //    for (int i : ls)
        //        System.out.print(i + " ");
        //    System.out.println();
        //}
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> ls = new LinkedList<>();
        combine(candidates, 0, target, res, ls);
        return res;
    }

    public void combine(int[] candidates, int beg, int target, List<List<Integer>> res, List<Integer> ls) {
        if (target == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for (int i = beg; i < candidates.length && candidates[i] <= target; i++) {
            if (i == beg || (i > beg && candidates[i] != candidates[i - 1])) {
                ls.add(candidates[i]);
                combine(candidates, i + 1, target - candidates[i], res, ls);
                ls.remove(ls.size() - 1);
            }
        }
    }


}
