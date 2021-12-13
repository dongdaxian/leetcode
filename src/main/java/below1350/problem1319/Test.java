package below1350.problem1319;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1)
            return -1;
        UnionFind uf = new UnionFind(n);
        int ret = 0;
        for(int[] temp: connections) {
            if(!uf.union(temp[0], temp[1])) {
                ret++;
            }
        }
        return n - 1 - (connections.length - ret);
    }
}
class UnionFind {
    private int[] parent;
    private int[] rank;
    public UnionFind(int n) {
        parent = IntStream.range(0, n).toArray();
        rank = new int[n];
        Arrays.fill(rank, 1);
    }
    public int find(int i) {
        if(parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    public boolean union(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if(rooti == rootj)
            return false;
        if(rank[rooti] == rank[rootj]) {
            parent[rooti] = rootj;
            rank[rootj]++;
        } else if(rank[rooti] > rank[rootj]) {
            parent[rootj] = rooti;
        } else {
            parent[rooti] = rootj;
        }
        return true;
    }
}

