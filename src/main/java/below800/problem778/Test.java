package below800.problem778;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test {

    private final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean inField(int i, int j, int m, int n) {
        return i > -1 && i < m && j > -1 && j < n;
    }
    public int swimInWater(int[][] grid) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int m = grid.length;
        int n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        int maxTime = grid[0][0];
        queue.add(new int[]{grid[0][0], 0});
        visited[0] = true;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            maxTime = Math.max(maxTime, temp[0]);
            if(temp[1] == m * n - 1) {
                return maxTime;
            }
            int i = temp[1] / n;
            int j = temp[1] % n;
            for(int[] direc: DIRECTIONS) {
                int x = i + direc[0];
                int y = j + direc[1];
                if(inField(x, y, m, n) && !visited[x * n + y]) {
                    queue.add(new int[]{grid[x][y], x * n + y});
                    visited[x * n + y] = true;
                }
            }
        }
        return 0;
    }

}
