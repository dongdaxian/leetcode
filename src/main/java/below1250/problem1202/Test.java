package below1250.problem1202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.compute(2, (k, v) -> k));

    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        UnionFind uf = new UnionFind(len);
        for (List<Integer> ls : pairs) {
            uf.union(ls.get(0), ls.get(1));
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int ancestor = uf.find(i);
//			if(map.containsKey(ancestor)) {
//				map.get(ancestor).add(i);
//			} else {
//				List<Integer> temp = new ArrayList<>();
//				temp.add(i);
//				map.put(ancestor, temp);
//			}
//			使用Java8新增的compute、computeIfAbsent			
//			会把键值作为参数传入参数a中，只是这里用不到 
            map.computeIfAbsent(ancestor, a -> new ArrayList<>()).add(i);

        }
        char[] res = new char[len];
        for (List<Integer> ls : map.values()) {
            int size = ls.size();
            char[] temp = new char[size];
            for (int i = 0; i < size; i++) {
                temp[i] = s.charAt(ls.get(i));
            }
            Arrays.sort(temp);
            //第二种实现方法，用ancestor作键值保存temp，最后构造一个StringBuilder，每次循环，append() i对应的ancestor对应的temp中第一个元素(所以最好用队列替换字符数组temp)
            for (int i = 0; i < size; i++) {
                res[ls.get(i)] = temp[i];
            }
        }

        return new String(res);
    }

}

//同时使用了路径压缩和按秩合并
class UnionFind {
    int[] parent;
    int[] rank;


    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j) {
        int roota = find(i);
        int rootb = find(j);
        if (roota == rootb) return;
        if (rank[roota] == rank[rootb]) {
            parent[roota] = rootb;
            rank[rootb]++;
        } else if (rank[roota] < rank[rootb]) {
            parent[roota] = rootb;
        } else {
            parent[rootb] = roota;
        }

    }
}
