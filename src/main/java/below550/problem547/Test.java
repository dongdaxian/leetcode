package below550.problem547;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(3);
		set.remove(2);
		for(int temp: set) {
			System.out.println(temp);
		}
	}
	
	public int findCircleNum(int[][] isConnected) {
		//Ҳ������ boolean[] visited������set
        Set<Integer> set = new HashSet<>();
        int len = isConnected.length;
        for(int i = 0; i < len; i++) {
            set.add(i);
        }
        for(int i = 0; i < len; i++) {
            if(dfs(set, i, isConnected)) {
            	//ʹ��circles��¼����������ʡ����һ������dfsҲ����û�з���ֵ
                set.add(i);
            }
        }
        return set.size();
    }
	//dfsҲ������Ƴ�û�з���ֵ������Ҫ��֤����dfs��i��һ����set.contains(i)����dfs�ڲ��ڵݹ����ʱҲҪ��֤set.contains(j)
    public boolean dfs(Set<Integer> set, int i, int[][] con) {
        if(!set.contains(i)) return false;
        set.remove(i);
        for(int j = 0; j < con.length; j++) {
            if(con[i][j] == 1) {
                dfs(set, j, con);
            }
        }
        return true;
    }
    
    //�ò��鼯
    public int findCircleNum2(int[][] isConnected) {
    	int len = isConnected.length;
    	UnionFind uf = new UnionFind(len);
    	for(int i = 0; i < len; i++) {
    		for(int j = i + 1; j < len; j++) {
    			if(isConnected[i][j] == 1) {
    				uf.union(i, j);
    			}
    		}
    	}
    	return uf.size;
    }
    
}

class UnionFind {
	int[] parent;
	int size;
	public UnionFind(int n) {
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
			size = n;
		}
	}
	
	public void union(int a, int b) {
		//�������鼯ֻ��Ҫ parent[find(b)] = find(a)
		int roota = find(a);
		int rootb = find(b);
		if(roota != rootb) {
			parent[rootb] = roota;
			size--;
		}
	}
	
	public int find(int tar) {
		if(parent[tar] != tar) {
			parent[tar] = find(parent[tar]);
		}
		return parent[tar];
	}
}
