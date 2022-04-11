package below250.problem216;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> res = new Test().combinationSum3(3, 7);
        for (List<Integer> ls : res) {
            for (int temp : ls)
                System.out.print(temp + " ");
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        combine2(res, ls, k, n, 1);
        return res;
    }

    public void combine(List<List<Integer>> res, List<Integer> ls, int leftK, int leftN, int beg) {
        if (leftK == 0 && leftN == 0)
            res.add(new ArrayList<>(ls));
        else if (leftK == 0 || leftN == 0)
            return;
        for (int i = beg; i < 10 && i <= leftN; i++) {
            ls.add(i);
            combine(res, ls, leftK - 1, leftN - i, i + 1);
            ls.remove(ls.size() - 1);
        }
    }

    public void combine2(List<List<Integer>> res, List<Integer> ls, int leftK, int leftN, int beg) {
        if (leftK == 0 && leftN == 0) {
            res.add(new ArrayList<>(ls));
        }
        if (leftK == 0 || leftN == 0 || beg >= 10) {
            return;
        }
        if (beg <= leftN) {
            ls.add(beg);
            combine2(res, ls, leftK - 1, leftN - beg, beg + 1);
            ls.remove(ls.size() - 1);
        }
        combine2(res, ls, leftK, leftN, beg + 1);
    }
}
