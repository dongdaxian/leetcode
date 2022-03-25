package below100.problem63;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Map<Integer, Integer> dp = new HashMap<>();
        return dfs(m, n, obstacleGrid, dp, 0);
    }

    private int dfs(int m, int n, int[][] obstacleGrid, Map<Integer, Integer> dp, int index) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        }
        if (obstacleGrid[index / n][index % n] == 1) {
            return 0;
        }
        if (index == m * n - 1) {
            return 1;
        }
        if (index % n < n - 1) {
            dp.put(index, dp.getOrDefault(index, 0) + dfs(m, n, obstacleGrid, dp, index + 1));
        }
        if (index / n < m - 1) {
            dp.put(index, dp.getOrDefault(index, 0) + dfs(m, n, obstacleGrid, dp, index + n));
        }
        return dp.getOrDefault(index, 0);
    }
}
