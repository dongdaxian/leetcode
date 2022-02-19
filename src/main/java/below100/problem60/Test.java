package below100.problem60;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().getPermutation(9, 214267));
    }


    //时间复杂度是 O(n!)
    int count = 1;

    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        sortK(n, k, res);
        String temp = "";
        for (int i : res)
            temp += i;
        return temp;
    }


    public boolean sortK(int n, int k, List<Integer> res) {
        if (res.size() == n) {
            if (count == k)
                return true;
            else {
                count++;
                return false;
            }

        }
        //此处对应46题的选择，也可以用插入、交换
        for (int i = 1; i <= n; i++) {
            if (res.contains(i))
                continue;
            res.add(i);
            if (sortK(n, k, res))
                return true;
            res.remove(res.size() - 1);
        }
        return false;
    }


    public String getPermutation2(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringBuilder sb = new StringBuilder();
        boolean[] ifUse = new boolean[n];
        --k;
        for (int i = 0; i < n; i++) {
            int order = k / factorial[n - i - 1];

            for (int j = 0; j < n; j++) {
                if (!ifUse[j]) {
                    if (order == 0) {
                        ifUse[j] = true;
                        sb.append(j + 1);
                        break;
                    }
                    --order;
                }
            }

            k = k % factorial[n - i - 1];
        }

        return sb.toString();
    }

}
