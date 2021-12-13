package below1250.problem1203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {

		int[][] array = new int[][] {{},{6},{5},{6},{3,6},{},{},{}};
		List<List<Integer>> ls = Arrays.stream(array).map(k -> Arrays.stream(k).boxed().collect(Collectors.toList())).collect(Collectors.toList());
		new Test().sortItems(8, 2, new int[] {-1,-1,1,0,0,1,0,-1}, ls);
		
		
	}
	
//	此题难点在于对项目和组各用一次拓扑排序
//	拓扑排序需要每个节点的入度和节点指向的节点列表
	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
//		避免把-1当成一个组
		for(int i = 0; i < n; i++) {
			if(group[i] == -1) {
				group[i] = m++;
			}
		}
		List<Integer>[] groupAdj = new ArrayList[m];
		List<Integer>[] itemAdj = new ArrayList[n];
		for(int i = 0; i < m; i++) {
			groupAdj[i] = new ArrayList<>();
		}
		for(int i = 0; i < n; i++) {
			itemAdj[i] = new ArrayList<>();
		}
		int[] groupIndegree = new int[m];
		int[] itemIndegree = new int[n];
//		初始化
		for(int i = 0; i < n; i++) {
			for(int j: beforeItems.get(i)) {
				itemAdj[j].add(i);
				itemIndegree[i]++;
				if (group[j] != group[i]) {
					groupAdj[group[j]].add(group[i]);
					groupIndegree[group[i]]++;
				}
			}
		}
		int[] groupRet = topologicalSort(groupAdj, groupIndegree);
		int[] itemRet = topologicalSort(itemAdj, itemIndegree);
		if(groupRet == null || itemRet == null) {
			return new int[0];
		}
		List<Integer> res = new ArrayList<>();
		List<Integer>[] itemOfGroup = new ArrayList[m];
		for(int i = 0; i < m; i++) {
			itemOfGroup[i] = new ArrayList<>();
		}
		for(int i: itemRet) {
			itemOfGroup[group[i]].add(i);
		}
		for(int i: groupRet) {
			res.addAll(itemOfGroup[i]);
		}
//		ls.stream().mapToInt(k -> k).toArray()
//		下面这种做法多了一次装箱拆箱
		return res.stream().mapToInt(Integer::valueOf).toArray();
	}
	
	public int[] topologicalSort(List<Integer>[] ls, int[] indegree) {
		int len = indegree.length;
		Queue<Integer> queue = new LinkedList<>();
		int[] res = new int[len];
		int ptr = 0;
		for(int i = 0; i < len; i++) {
			if(indegree[i] == 0)
				queue.add(i);
		}
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			res[ptr++] = temp;
			List<Integer> tempLs = ls[temp];
			for(int i: tempLs) {
				if(--indegree[i] == 0) {
					queue.offer(i);
				}
			}
		}
		if(ptr != len)
			return null;
		return res;
	}
	
	
	
}
