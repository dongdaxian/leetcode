package below550.problem514;

import java.util.*;

public class Test {
    public static void main(String[] args) {

    }

    //记忆化搜索
    public int findRotateSteps(String ring, String key) {
        return getSteps(ring, 0, key, 0, ring.length(), new HashMap<>());
    }

    public int getSteps(String ring, int ptra, String key, int ptrb, int len, Map<String, Integer> map) {
        if (ptrb == key.length())
            return 0;
        if (map.containsKey(ptra + " " + ptrb))
            return map.get(ptra + " " + ptrb);
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i <= len / 2; i++) {
            if (ring.charAt((ptra + i) % len) == key.charAt(ptrb)) {
                temp = Math.min(temp, i + 1 + getSteps(ring, (ptra + i) % len, key, ptrb + 1, len, map));
            }
            if (ring.charAt((ptra - i + len) % len) == key.charAt(ptrb)) {
                temp = Math.min(temp, i + 1 + getSteps(ring, (ptra - i + len) % len, key, ptrb + 1, len, map));
            }
        }
        map.put(ptra + " " + ptrb, temp);
        return temp;
    }


    //动态规划，注意正好和记忆化搜索记录方向相反
    //与一般动态规划区别在于每次处理一个dp一维数组，dp中也不是每个元素都有用
    public int findRotateSteps2(String ring, String key) {
        int n = ring.length(), m = key.length();
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            map.putIfAbsent(ring.charAt(i), new HashSet<>());
            map.get(ring.charAt(i)).add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i: map.get(key.charAt(0))) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j: map.get(key.charAt(i))) {
                for (int k: map.get(key.charAt(i - 1))) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }

        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

}
