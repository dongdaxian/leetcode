package below800.problem765;

public class Test {
    public int minSwapsCouples(int[] row) {
        UnionFind unionFind = new UnionFind(row.length / 2);
        for (int i = 0; i < row.length / 2; i++) {
            int left = row[i * 2];
            int right = row[i * 2 + 1];
            unionFind.union(left / 2, right / 2);
        }
        return unionFind.count;
    }


}


class UnionFind {

    private int[] parent;
    public int count;

    public UnionFind(int n) {
        count = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }


    public void union(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if (rootj != rooti) {
            parent[rooti] = rootj;
            count++;
        }
    }
}