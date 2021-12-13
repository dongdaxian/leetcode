package below850.problem834;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		int[] res = new Test().sumOfDistancesInTree2(6, new int[][] {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
		for(int dis: res)
			System.out.println(dis + " ");
	}
	
	//用的是弗洛伊德算法(迪杰斯特拉算法的思想)，但不同之处在于，本题路径唯一不用求最短距离，所以这种做法的时间复杂度高
	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		int[][] dis = new int[N][N];
		for(int[] temp: dis) {
			Arrays.fill(temp, Integer.MAX_VALUE / 2);
		}
		for(int i = 0; i < N; i++)
			dis[i][i] = 0;
		for(int[] temp: edges) {
			dis[temp[0]][temp[1]] = 1;
			dis[temp[1]][temp[0]] = 1;
		}
		for(int k = 0; k < N; k++)
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					dis[i][j] = Integer.min(dis[i][j], dis[i][k] + dis[k][j]);
		
		int[] res = new int[N];
		for(int i = 0; i < N; i++) {
			for(int sdis: dis[i]) {
				res[i] += sdis;
			}
		}
		
		return res;
    }

	//由于路径唯一，只需要挨个遍历即可求出到某一节点距离之和，对于N个节点，复杂度为O(N^2)
	//到u的距离之和与到v的距离之和是有关系的(前提是u、v相邻)，针对这一点再优化，还可以减小时间复杂度
	public int[] sumOfDistancesInTree2(int N, int[][] edges) {
		int[] res = new int[N];										//最终结果
		int[] dp = new int[N];										//dp[i]代表以i为根节点的子树中，子节点到i的距离之和。默认整个树的根节点是0
		int[] sz = new int[N];										//sz[i]代表以i为根节点的子树的子节点数之和
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < N; i++)
			graph.add(new ArrayList<>());
		for(int[] temp: edges) {
			graph.get(temp[0]).add(temp[1]);
			graph.get(temp[1]).add(temp[0]);
		}
		getFirstNodeDis(graph, dp, sz, 0, -1);
		getLeftNodeDis(graph, res, dp, sz, 0, -1);
		
		return res;
	}
	public void getFirstNodeDis(List<List<Integer>> graph, int[] dp, int[] sz, int beg, int forbidden) {
		List<Integer> temp = graph.get(beg);
		dp[beg] = 0;
		sz[beg] = 1;
		for(int v: temp) {
			if(v == forbidden)
				continue;
			getFirstNodeDis(graph, dp, sz, v, beg);
			dp[beg] += dp[v] + sz[v];
			sz[beg] += sz[v];
		}
	}
	public void getLeftNodeDis(List<List<Integer>> graph, int[] res, int[] dp, int[] sz, int beg, int forbidden) {
		res[beg] = dp[beg];
		List<Integer> temp = graph.get(beg);
		for(int v: temp) {
			if(v == forbidden)
				continue;
			int bdp = dp[beg], bsz = sz[beg];
			int vdp = dp[v], vsz = sz[v];
			dp[beg] -= dp[v] + sz[v];
			sz[beg] -= sz[v];
			dp[v] += dp[beg] + sz[beg];
			sz[v] += sz[beg];
			getLeftNodeDis(graph, res, dp, sz, v, beg);
			dp[beg] = bdp;
			dp[v] = vdp;
			sz[beg] = bsz;
			sz[v] = vsz;
		}
	}
	
}
