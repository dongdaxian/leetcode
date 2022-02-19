package below100.problem57;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{};
        int[] newInterval = new int[]{5, 7};
        intervals = new Test().insert1(intervals, newInterval);
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(intervals[i][j]);
            System.out.println();
        }

    }


    public int[][] insert1(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) return null;
        if (newInterval.length == 0) return intervals;
        if (intervals.length == 0) return new int[][]{newInterval};
        LinkedList<int[]> ls = new LinkedList<>();
        int[] curarr;
        int[] lastarr;
        boolean flag = false;                            //标记newInterval是否已经加入到ls中
        for (int i = 0; i < intervals.length; i++) {
            curarr = intervals[i];
//			if(!flag) {									
//				if(curarr[0] > newInterval[0]){			
//					if(curarr[0] > newInterval[1])
//						ls.add(newInterval);
//					else
//						curarr[0] = newInterval[0];
//					flag = true;
//				}
//				if(curarr[1] >= newInterval[0]) {
//					curarr[1] = Integer.max(newInterval[1], curarr[1]);
//					flag = true;
//				}	
//				ls.add(curarr);

            if (!flag) {                                                    //当newInterval没有加入到ls中时   写成if--else if比嵌套if省时
                if (newInterval[1] < curarr[0]) {
                    ls.add(newInterval);
                    flag = true;
                } else if (newInterval[0] < curarr[0]) {
                    curarr[0] = newInterval[0];
                    curarr[1] = Integer.max(newInterval[1], curarr[1]);
                    flag = true;
                } else if (newInterval[0] <= curarr[1]) {
                    curarr[1] = Integer.max(newInterval[1], curarr[1]);
                    flag = true;
                }
                ls.add(curarr);
            } else {
                lastarr = ls.getLast();
                if (lastarr[1] >= curarr[0]) {
                    lastarr[1] = Integer.max(lastarr[1], curarr[1]);
                } else {
                    ls.add(curarr);
                }
            }

        }
        if (!flag)
            ls.add(newInterval);
        return ls.toArray(new int[ls.size()][2]);
    }


    public int[][] insert2(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ls = new LinkedList<>();
        for (int[] curarr : intervals) {                                    //因为四种交叉的处理方式都是一样的，所以可以简化考虑的情形，要么在左，要么在右，要么有重叠
            if (newInterval == null || curarr[1] < newInterval[0]) {
                ls.add(curarr);
            } else if (curarr[0] > newInterval[1]) {
                ls.add(newInterval);
                ls.add(curarr);
                newInterval = null;                                        //用newInterval是否为null当作flag
            } else {                                                    //对于交叉统一处理，newInterval不必急着加入
                newInterval[0] = Math.min(newInterval[0], curarr[0]);
                newInterval[1] = Math.max(newInterval[1], curarr[1]);
            }
        }
        if (newInterval != null)
            ls.add(newInterval);
        return ls.toArray(new int[ls.size()][2]);
    }

    //56题方式
    public int[][] insert3(int[][] intervals, int[] newInterval) {
    	List<int[]> ls = Arrays.stream(intervals).collect(Collectors.toList());
    	ls.add(newInterval);
		ls.sort((Comparator.comparingInt(o -> o[0])));

		List<int[]> res = new ArrayList<>();

		int[] pre = ls.get(0);
		res.add(pre);
		int[] cur;
		for (int i = 1; i < ls.size(); i++) {
			cur = ls.get(i);
			if (cur[0] <= pre[1]) {
				if (cur[1] > pre[1])
					pre[1] = cur[1];
			} else {
				pre = cur;
				res.add(cur);
			}
		}
		return res.toArray(new int[res.size()][2]);

	}

}
