package below1600.problem1584;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Test {

    public static void main(String[] args) {
        new Test().minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}});
    }

//    Prim
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] dis = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                dis[i][j] = distance;
                dis[j][i] = distance;
            }
        }
        int minDis = 0;
//        Set<Integer> addSet = new HashSet<>();
//        Set<Integer> toAddSet = new HashSet<>(IntStream.range(1, n).boxed().collect(Collectors.toList()));
//        addSet.add(0);
//        while(!toAddSet.isEmpty()) {
//            int min = Integer.MAX_VALUE;
//            int record = 0;
//            for(int base: addSet) {
//                for(int end: toAddSet) {
//                    if(dis[base][end] < min) {
//                        record = end;
//                        min = dis[base][end];
//                    }
//                }
//            }
//            minDis += min;
//            addSet.add(record);
//            toAddSet.remove(record);
//        }

        Set<Integer> addSet = new HashSet<>();
        addSet.add(0);
//        记录节点到当前已生成图的最短距离，当然，节点不能在addSet中
        int[] pdis = new int[n];
        Arrays.fill(pdis, Integer.MAX_VALUE);
        for(int i = 1; i < n; i++) {
            pdis[i] = Math.min(pdis[i], dis[0][i]);
        }
//        可以用toAddSet是否为空来判断，也可以循环n - 1次，循环结束意味着所有节点都已添加
        for(int i = 1; i < n; i++) {
            int disRecord = Integer.MAX_VALUE;
            int pointRecord = 0;
            for(int j = 0; j < n; j++) {
                if(addSet.contains(j))
                    continue;
                if(disRecord > pdis[j]) {
                    pointRecord = j;
                    disRecord = pdis[j];
                }
            }
            addSet.add(pointRecord);
            minDis += disRecord;
//            相比于上面的实现方法，避免了每次都遍历已有集合中所有节点
            for(int j = 0; j < n; j++) {
                if(addSet.contains(j))
                    continue;
                pdis[j] = Math.min(pdis[j], dis[j][pointRecord]);
            }
        }
        return minDis;
    }

//    Kruskal
    public int minCostConnectPoints2(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        List<Edge> ls = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                ls.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        Collections.sort(ls, (v1, v2) -> v1.len - v2.len);
        int count = 1;
        int minDis = 0;
        for(int i = 0; i < ls.size(); i++) {
            Edge temp = ls.get(i);
            if(uf.union(temp.begin, temp.end)) {
                count++;
                minDis += temp.len;
                if(count == n)
                    break;
            }
        }
        return minDis;
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
            size[i] = i;
        }
    }
    public int find(int ta) {
        if(parent[ta] != ta) {
            parent[ta] = find(parent[ta]);
        }
        return parent[ta];
    }
    public boolean union(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if(rootj != rooti) {
            if(size[rootj] >= size[rooti]) {
                size[rooti] += size[rootj];
                parent[rootj] = rooti;
            } else {
                size[rootj] += size[rooti];
                parent[rooti] = rootj;
            }
            return true;
        }
        return false;
    }
}
class Edge {
    int begin;
    int end;
    int len;
    public Edge(int begin, int end, int len) {
        this.begin = begin;
        this.end = end;
        this.len = len;
    }
}