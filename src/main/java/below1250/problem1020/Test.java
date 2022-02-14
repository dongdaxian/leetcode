package below1250.problem1020;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().numEnclaves(new int[][]{{0,0,1,1,1,0,1,1,1,0,1},{1,1,1,1,0,1,0,1,1,0,0},{0,1,0,1,1,0,0,0,0,1,0},{1,0,1,1,1,1,1,0,0,0,1},{0,0,1,0,1,1,0,0,1,0,0},{1,0,0,1,1,1,0,0,0,1,1},{0,1,0,1,1,0,0,0,1,0,0},{0,1,1,0,1,0,1,1,1,0,0},{1,1,0,1,1,1,0,0,0,0,0},{1,0,1,1,0,0,0,1,0,0,1}}));
    }

    public int numEnclaves(int[][] grid) {
        int num = 0;
        int m = grid.length;
        int n = grid[0].length;
        UnionFind unionFind = new UnionFind();

        for (int i = 0; i < m * n; i++) {
            if (grid[i / n][i % n] == 1) {
                unionFind.find(i);
                if (unionFind.parent.containsKey(i - n)) {
                    unionFind.union(i, i - n);
                }
                if (unionFind.parent.containsKey(i - 1)) {
                    unionFind.union(i, i - 1);
                }

            }
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: unionFind.parent.entrySet()) {
            int root = unionFind.find(entry.getKey());
            map.putIfAbsent(root, new HashSet<>());
            map.get(root).add(entry.getKey());
        }
        Set<Integer> boundaryRoot = new HashSet<>();
        for (int k = 0; k < m * n; k++) {
            if (onBoundary(k / n, k % n, m, n)) {
                boundaryRoot.add(unionFind.find(k));
            }
        }
        for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            if (!boundaryRoot.contains(entry.getKey())) {
                num += entry.getValue().size();
            }
        }
        return num;
    }

    public boolean onBoundary(int i, int j, int m, int n) {
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
            return true;
        }
        return false;
    }
}

class UnionFind {
    public Map<Integer, Integer> parent;
    public UnionFind() {
        parent = new HashMap<>();
    }

    public int find(int n) {
        if (!parent.containsKey(n)) {
            parent.put(n, n);
        }
        if (parent.get(n).equals(n)) {
            return n;
        }
        parent.put(n, find(parent.get(n)));
        return parent.get(n);
    }
    public void union(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if (rooti != rootj) {
            parent.put(rooti, rootj);
        }
    }
}
