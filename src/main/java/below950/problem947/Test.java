package below950.problem947;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		
	}
	
//	本质上是找有多少个连通图
	public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for(int[] temp: stones) {
//        	转换成一维，前提是转化后的两个点必须连起来，且不能和另一条轴上任何点重合
            uf.union(temp[0] + 10001, temp[1]);
        }
        return stones.length - uf.count;
    }
	
}

class UnionFind {
//	坐标大小不定，所以此处用Map代替int[]，但本质一样
    Map<Integer, Integer> parent;
    int count;
    public UnionFind() {
        parent = new HashMap<>();
        count = 0;
    }
    public int find(int i) {
        if(!parent.containsKey(i)) {
            parent.put(i, i);
            count++;
        }
//      也可以用else if
        if(parent.get(i) != i) {
            parent.put(i, find(parent.get(i)));
        }
        return parent.get(i);
    }
    public void union(int i, int j) {
        int roota = find(i);
        int rootb = find(j);
        if(roota != rootb) {
            parent.put(roota, rootb);
            count--;
        }
    }
}
