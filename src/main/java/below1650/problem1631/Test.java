package below1650.problem1631;

import java.util.*;
import java.util.stream.IntStream;

public class Test {

    private final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean inField(int i, int j, int m, int n) {
        return i > -1 && i < m && j > -1 && j < n;
    }

    public static void main(String[] args) {
        System.out.println(new Test().minimumEffortPath2(new int[][]{{1,2,1},{1,2,1},{1,1,1}}));
    }

//    深度遍历，超时
    private int maxInterval = Integer.MAX_VALUE;
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(0, 0, 0, visited, heights, m, n);
        return this.maxInterval;
    }
    public void dfs(int i, int j, int interval, boolean[][] visited, int[][] heights, int m, int n) {
        if(i == m - 1 && j == n - 1) {
            this.maxInterval = interval;
            return;
        }
        visited[i][j] = true;
        for(int[] temp: DIRECTIONS) {
            int x = i + temp[0];
            int y = j + temp[1];
            if(inField(x, y, m, n) && !visited[x][y]) {
                int tempInterval = Math.max(interval, Math.abs(heights[x][y] - heights[i][j]));
                if(tempInterval >= this.maxInterval)
                    continue;
                dfs(x, y, tempInterval, visited, heights, m, n);
            }

        }
        visited[i][j] = false;
    }

//    深度遍历剪枝
//    此题和普通的深度遍历不太相同，一个节点可能会被遍历多次
//    类似于记忆化搜索，但区别在于此题并不能采用分治法分成小任务，记录内容也不是小任务的答案，仅仅是为了剪枝
    public int minimumEffortPath2(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[] visited = new boolean[m * n];
        int[] intervals = new int[m * n];
        Arrays.fill(intervals, Integer.MAX_VALUE);
        intervals[0] = 0;
        dfs2(0, 0, intervals, visited, heights, m, n);
        return intervals[m * n - 1];
    }
    public void dfs2(int i, int j, int[] intervals, boolean[] visited, int[][] heights, int m, int n) {
        int interval = intervals[i * n + j];
        visited[i * n + j] = true;

        for(int[] temp: DIRECTIONS) {
            int x = i + temp[0];
            int y = j + temp[1];
            if(inField(x, y, m, n) && !visited[x * n + y]) {
                int tempInterval = Math.max(interval, Math.abs(heights[x][y] - heights[i][j]));
                if(tempInterval < intervals[x * n + y] && tempInterval < intervals[m * n - 1]) {
//                    intervals赋值也可以放在dfs开头，但是需要额外传入参数
                    intervals[x * n + y] = tempInterval;
                    dfs2(x, y, intervals, visited, heights, m, n);
                }
            }
        }
        visited[i * n + j] = false;
    }

//    此题中，同一个节点如果不多次遍历会漏掉可能性，但多次遍历时间复杂度又很高，采取的解决方式有两个
//    解法一：采用节点只遍历一次的dfs/bfs，但额外使用二分法保证不漏掉可能性


//    解法二：用优先队列控制遍历的方向
//    也可以理解成Dijkstra算法，只是计算距离的方式改了
    public int minimumEffortPath3(int[][] heights) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{0, 0, 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cost = cur[0];
            int i = cur[1];
            int j = cur[2];
            if(i == m - 1 && j == n - 1)
                return cost;
            if(!visited[i][j]) {
                visited[i][j] = true;
                for(int[] temp: DIRECTIONS) {
                    int x = i + temp[0];
                    int y = j + temp[1];
                    if(inField(x, y, m, n) && !visited[x][y]) {
                        int tempCost = Math.max(cost, Math.abs(heights[x][y] - heights[i][j]));
//                        通过记录(x, y)的最小cost，来判断当前tempCost是否应该加入队列，可以减小时间复杂度
                        queue.offer(new int[]{tempCost, x, y});
                    }
                }
            }
        }
        return 0;
    }

//    用并查集，对所有边排序，逐渐加入，当左上角与右下角连通，最后加入的边的权值就是答案

}
