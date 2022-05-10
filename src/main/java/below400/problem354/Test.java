package below400.problem354;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o2[1] - o1[1];
        });
//        变成第300题最长子序列，使用动态规划解法
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int ret = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1])
                    res[i] = Math.max(res[i], res[j] + 1);
            }
            ret = Math.max(ret, res[i]);
        }
        return ret;
    }

    //    使用300题的贪心+二分查找解法
    public int maxEnvelopes2(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o2[1] - o1[1];
        });
        List<Integer> ls = new ArrayList<>();
        ls.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            int num = envelopes[i][1];
            if (num > ls.get(ls.size() - 1)) {
                ls.add(num);
            } else {
                int index = binarySearch(ls, num);
                ls.set(index, num);
            }
        }
        return ls.size();
    }

    public int binarySearch(List<Integer> ls, int tar) {
        int left = 0, right = ls.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (ls.get(mid) < tar) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
