package below250.problem207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {

        System.out.print(new Test().canFinish(2, new int[][]{{1, 0}}));
    }

    //其实就是检查是否存在有向无环图，所以可以应用拓扑排序，所以需要用到邻接表（此处不用链表的形式最为方便）

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();    //邻接表
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] indegrees = new int[numCourses];    //入度表
        for (int[] arr : prerequisites) {
            indegrees[arr[0]]++;
            adjacency.get(arr[1]).add(arr[0]);
        }

        //BFS1
//		boolean[] flag = new boolean[numCourses];
//		int count = 0;
//		while(true) {
//			int i = 0;
//			for(; i < numCourses && (indegrees[i] != 0 || flag[i] == true); i++);
//			if(i == numCourses)
//				return count == numCourses;
//			else {
//				for(int point: adjacency.get(i))
//					indegrees[point]--;
//				count++;
//				flag[i] = true;
//			}
//		}

        //BFS2
        //采取集合的方式，因为不存在先后顺序，只要求能移除元素，所以List、Set、Queue都可以
//		Queue<Integer> queue = new LinkedList<>();
//		for(int i = 0; i < numCourses; i++) {
//			if(indegrees[i] == 0) {
//				queue.add(i);
//			}
//		}
//		while(!queue.isEmpty()) {
//			int index = queue.poll();
//			numCourses--;
//			for(int point: adjacency.get(index)) {
//				if(--indegrees[point] == 0) {
//					queue.add(point);
//				}
//			}
//		}
//		return numCourses == 0;

        //DFS
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (int j : adjacency.get(i))
            if (!dfs(adjacency, flags, j))
                return false;
        flags[i] = -1;
        return true;
    }


}
