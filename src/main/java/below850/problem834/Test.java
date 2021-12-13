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
	
	//�õ��Ǹ��������㷨(�Ͻ�˹�����㷨��˼��)������֮ͬ�����ڣ�����·��Ψһ��������̾��룬��������������ʱ�临�Ӷȸ�
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

	//����·��Ψһ��ֻ��Ҫ�����������������ĳһ�ڵ����֮�ͣ�����N���ڵ㣬���Ӷ�ΪO(N^2)
	//��u�ľ���֮���뵽v�ľ���֮�����й�ϵ��(ǰ����u��v����)�������һ�����Ż��������Լ�Сʱ�临�Ӷ�
	public int[] sumOfDistancesInTree2(int N, int[][] edges) {
		int[] res = new int[N];										//���ս��
		int[] dp = new int[N];										//dp[i]������iΪ���ڵ�������У��ӽڵ㵽i�ľ���֮�͡�Ĭ���������ĸ��ڵ���0
		int[] sz = new int[N];										//sz[i]������iΪ���ڵ���������ӽڵ���֮��
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
