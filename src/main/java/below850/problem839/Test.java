package below850.problem839;

import java.util.stream.IntStream;

public class Test {

    public int numSimilarGroups(String[] strs) {
        int len = strs[0].length();
        UnionFind uf = new UnionFind(strs.length);
        for(int i = 0; i < strs.length; i++) {
            String target = strs[i];
            for(int j = 0; j < i; j++) {
                if(uf.ifUnion(i, j))
                    continue;
                String base = strs[j];
                int diff = 0;
                for(int k = 0; k < len; k++) {
                    if(target.charAt(k) != base.charAt(k))
                        diff++;
                }
                if(diff == 0 || diff == 2) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}
class UnionFind {
    private int[] parent;

//    也可以通过最后检查有多少个parent[i] == i来得到有多少连通分量
    int count;

    public UnionFind(int n) {
        this.parent = IntStream.range(0, n).toArray();
        this.count = n;
    }
    public int find(int i) {
        if(parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public boolean ifUnion(int i, int j) {
        int rooti = find(parent[i]);
        int rootj = find(parent[j]);
        if(rooti != rootj) {
            return false;
        }
        return true;
    }


    public void union(int i, int j) {
        int rooti = find(parent[i]);
        int rootj = find(parent[j]);
        if(rooti != rootj) {
            parent[rooti] = rootj;
            count--;
        }
    }

}

