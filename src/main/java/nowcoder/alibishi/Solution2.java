package nowcoder.alibishi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 {


//    dfs中运用剪枝法的前提是，从根节点连到叶节点的每条路径都不经过其他叶节点，此题用不了
    static long ret = 0;
    public static void dfs(int[][] cost, int leftTime, int[] salary, long val, int beg) {
        boolean flag = false;
        int[] record = cost[beg];

        for (int i = 0; i < record.length; i++) {
            if (record[i] != -1 && record[i] <= leftTime) {
                flag = true;
                int tmp = record[i];
                record[i] = -1;
                if (cost[i][beg] == -1) {
                    dfs(cost, leftTime - tmp, salary, val, i);
                } else {
                    dfs(cost, leftTime - tmp, salary, val + salary[i], i);
                }
                record[i] = tmp;

            }
        }
        if (!flag && beg == 0) {
            ret = Math.max(ret, val);
        }
    }

//    dfs实现树形dp
//    t从大到小是为了避免重复消费某一颗子树
    public static void dfs(int[][] dp, int[] timeCost, Map<Integer, Set<Integer>> map, int beg, int time) {
        if (map.containsKey(beg)) {
            for (int tmp: map.get(beg)) {
                dfs(dp, timeCost, map, tmp, time);
                for (int t = time; t > -1; t--) {
                    for (int k = 0; k + timeCost[tmp] <= t; k++) {
                        dp[beg][t] = Math.max(dp[beg][t], dp[beg][k] + dp[tmp][t - k - timeCost[tmp]]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int time = sc.nextInt();
//        int[][] cost = new int[n][n];
//        int[] salary = new int[n];
//        for (int i = 0; i < n; i++) {
//            salary[i] = sc.nextInt();
//            Arrays.fill(cost[i], -1);
//        }
//        for (int i = 0; i < n - 1; i++) {
//            int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
//            int val = sc.nextInt();
//            cost[x][y] = val;
//            cost[y][x] = val;
//        }
//        ret = salary[0];
//        dfs(cost, time, salary, salary[0], 0);
//        System.out.print(ret);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int time = sc.nextInt() / 2;
        Set<Integer> tmpSet = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toSet());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[][] dp = new int[n + 1][time + 1];
        int[] timeCost = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            tmpSet.remove(y);
            if (!map.containsKey(x)) {
                Set<Integer> set = new HashSet<>();
                map.put(x, set);
            }
            map.get(x).add(y);
            timeCost[y] = sc.nextInt();
        }
        int beg = new ArrayList<>(tmpSet).get(0);
        dfs(dp, timeCost, map, beg, time);
        System.out.print(dp[beg][time]);
    }
}
