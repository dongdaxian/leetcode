package below700.problem684;

public class Test {
	public int[] findRedundantConnection(int[][] edges) {
		UnionFind uf = new UnionFind(edges.length + 1);
        for(int[] temp: edges) {
            if(uf.find(temp[0]) == uf.find(temp[1])) {
                return temp;
            }
            uf.union(temp[0], temp[1]);
        }
        return null;
	}
}
class UnionFind {
    public int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
    }
    public int find(int i) {
        if(parent[i] == i) 
            return i;
        return find(parent[i]);
    }
    public void union(int i, int j) {
        parent[find(i)] = parent[j];
    }
}