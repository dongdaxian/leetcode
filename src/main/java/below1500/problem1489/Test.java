package below1500.problem1489;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Test {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int edgeLen = edges.length;
        for(int i = 0; i < edgeLen; i++) {
            edges[i] = Arrays.copyOf(edges[i], 4);
            edges[i][3] = i;
        }
        Arrays.sort(edges, (v1, v2) -> v1[2] - v2[2]);

        int i = 0;
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> neEdge = new ArrayList<>();
        List<Integer> uneEdge = new ArrayList<>();
        ret.add(neEdge);
        ret.add(uneEdge);
        n--;
        while(i < edgeLen) {
            int len = edges[i][2];
            List<int[]> ls = new ArrayList<>();
            while(i < edgeLen && edges[i][2] == len) {
                int[] temp = edges[i];
                if(!uf.isUnion(temp[0], temp[1])) {
                    ls.add(temp);
                }
                i++;
            }
            if(!ls.isEmpty()) {
//                O(m ^ 2)，比起对ls全排序，然后记录每种顺序下每个int[]是否能union更好
                for(int j = 0; j < ls.size(); j++) {
                    UnionFind tempUf = new UnionFind(uf);
                    for(int k = 0; k < ls.size(); k++) {
                        if(j != k) {
                            tempUf.union(ls.get(k)[0], ls.get(k)[1]);
                        }
                    }
                    if(!tempUf.isUnion(ls.get(j)[0], ls.get(j)[1])) {
                        neEdge.add(ls.get(j)[3]);
                    } else {
                        uneEdge.add(ls.get(j)[3]);
                    }
                }
            }
            for(int[] temp: ls) {
                if(uf.union(temp[0], temp[1])) {
                    n--;
                    if(n == 0) {
                        return ret;
                    }
                }
            }
        }
        return null;
    }
}

class UnionFind {
    private int[] parent;
    public UnionFind(int n) {
        parent = IntStream.range(0, n).toArray();
    }
    public UnionFind(UnionFind uf) {
        int[] temp = uf.getParent();
        this.parent = Arrays.copyOf(temp, temp.length);
    }
    public int find(int k) {
        if(k != parent[k]) {
            parent[k] = find(parent[k]);
        }
        return parent[k];
    }
    public boolean isUnion(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if(rooti == rootj) {
            return true;
        }
        return false;
    }
    public boolean union(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if(rooti != rootj) {
            parent[rooti] = rootj;
            return true;
        }
        return false;
    }
    public int[] getParent() {
        return this.parent;
    }

}