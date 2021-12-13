package below950.problem947;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		
	}
	
//	�����������ж��ٸ���ͨͼ
	public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for(int[] temp: stones) {
//        	ת����һά��ǰ����ת�����������������������Ҳ��ܺ���һ�������κε��غ�
            uf.union(temp[0] + 10001, temp[1]);
        }
        return stones.length - uf.count;
    }
	
}

class UnionFind {
//	�����С���������Դ˴���Map����int[]��������һ��
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
//      Ҳ������else if
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
