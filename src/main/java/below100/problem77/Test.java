package below100.problem77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<List<Integer>> res = new Test().combine(2, 3);
        for (List<Integer> ls : res) {
            for (Integer x : ls)
                System.out.print(x + " ");
            System.out.println();
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        combineX(1, n, k, res, new LinkedList<>());
        return res;
    }

    public void combineX(int x, int n, int k, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        //采用DFS/回溯的选择
        for (int i = x; i <= n; i++) {
            list.add(i);
            combineX(i + 1, n, k, res, list);
            list.remove(list.size() - 1);
        }
    }

}
