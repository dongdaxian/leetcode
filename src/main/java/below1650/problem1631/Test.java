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

//    ��ȱ�������ʱ
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

//    ��ȱ�����֦
//    �������ͨ����ȱ�����̫��ͬ��һ���ڵ���ܻᱻ�������
//    �����ڼ��仯���������������ڴ��Ⲣ���ܲ��÷��η��ֳ�С���񣬼�¼����Ҳ����С����Ĵ𰸣�������Ϊ�˼�֦
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
//                    intervals��ֵҲ���Է���dfs��ͷ��������Ҫ���⴫�����
                    intervals[x * n + y] = tempInterval;
                    dfs2(x, y, intervals, visited, heights, m, n);
                }
            }
        }
        visited[i * n + j] = false;
    }

//    �����У�ͬһ���ڵ��������α�����©�������ԣ�����α���ʱ�临�Ӷ��ֺܸߣ���ȡ�Ľ����ʽ������
//    �ⷨһ�����ýڵ�ֻ����һ�ε�dfs/bfs��������ʹ�ö��ַ���֤��©��������


//    �ⷨ���������ȶ��п��Ʊ����ķ���
//    Ҳ��������Dijkstra�㷨��ֻ�Ǽ������ķ�ʽ����
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
//                        ͨ����¼(x, y)����Сcost�����жϵ�ǰtempCost�Ƿ�Ӧ�ü�����У����Լ�Сʱ�临�Ӷ�
                        queue.offer(new int[]{tempCost, x, y});
                    }
                }
            }
        }
        return 0;
    }

//    �ò��鼯�������б������𽥼��룬�����Ͻ������½���ͨ��������ıߵ�Ȩֵ���Ǵ�

}
