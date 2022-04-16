package below1000.problem959;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Test {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++) {
            char[] ch = grid[i].toCharArray();
            for(int j = 0; j < n; j++) {
                char temp = ch[j];
                int index = (i * n + j) * 4;
                if(temp == ' ') {
                    uf.union(index, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                } else if(temp == '/') {
                    uf.union(index, index + 1);
                    uf.union(index + 2, index + 3);
                } else {
                    uf.union(index, index + 2);
                    uf.union(index + 1, index + 3);
                }
            }
        }
        return uf.computeGraph();
    }
}
class UnionFind {
    private int[] parent;
    public UnionFind(int n) {
        int len = n * n;
        parent = IntStream.range(0, len * 4).toArray();
//        采用正向思考的方式也行
        for(int i = 0; i < len; i++) {
            int x = i / n;
            int y = i % n;
            if(x > 0)
                parent[i * 4] = (i - n) * 4 + 3;
            if(y > 0)
                parent[i * 4 + 1] = (i - 1) * 4 + 2;
        }
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
        if(rootj != rooti) {
            parent[rooti] = rootj;
        }
    }
    public int computeGraph() {
        Set<Integer> set = new HashSet<>();
        for(int temp: parent)
            set.add(find(temp));
        return set.size();
    }

}
