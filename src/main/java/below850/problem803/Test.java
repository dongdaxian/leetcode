package below850.problem803;

import java.util.Arrays;

public class Test {
	
	public int[] hitBricks(int[][] grid, int[][] hits) {
        final int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        int[][] copy = new int[m][n];
        for(int i = 0; i < m; i++)
            copy[i] = Arrays.copyOf(grid[i], n);
        for(int[] temp: hits) {
            copy[temp[0]][temp[1]] = 0;
        }
        for(int i = 0; i < n; i++) {
            if(copy[0][i] == 1)
                uf.union(i, m * n);
        }
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(copy[i][j] == 1) {
                    if(copy[i - 1][j] == 1) {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if(j > 0 && copy[i][j - 1] == 1) {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                }
            }
        }
        int len = hits.length;
        int[] ret = new int[len];
        for(int ptr = len - 1; ptr > -1; ptr--) {
            int[] temp = hits[ptr];
            int i = temp[0];
            int j = temp[1];
            int size = uf.getSize(m * n);
            if(i == 0)
                uf.union(j, m * n);
            if(grid[i][j] == 1) {
                for(int[] dir: DIRECTIONS) {
                    int tempi = i + dir[0];
                    int tempj = j + dir[1];
                    if(tempi >= 0 && tempi < m && tempj >= 0 && tempj < n && copy[tempi][tempj] == 1) {
                        uf.union(tempi * n + tempj, i * n + j);
                    }
                }
                int sub = uf.getSize(m * n) - size;
                ret[ptr] = sub > 0 ? sub - 1 : 0;
                copy[i][j] = 1;
            }
            
        }

        return ret;
    }
}
class UnionFind {
    private int[] parent;
    private int[] size;
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        size[n - 1] = 0;
    }
    public int find(int i) {
        if(parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    public void union(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if(rooti != rootj) {
            parent[rooti] = rootj;
            size[rootj] += size[rooti];
        }
    }
    public int getSize(int i) {
        return this.size[find(i)];
    }
}
