package below100.problem57;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		int[][] intervals = new int[][]{};
		int[] newInterval = new int[]{5, 7};
		intervals = new Test().insert1(intervals, newInterval);
		for(int i = 0; i < intervals.length; i++) {
			for(int j = 0; j < 2; j++)
				System.out.print(intervals[i][j]);
			System.out.println();
		}
		
	}
	
	
	public int[][] insert1(int[][] intervals, int[] newInterval) {
		if(intervals == null || newInterval == null) return null;
		if(newInterval.length == 0) return intervals;
		if(intervals.length == 0) return new int[][]{newInterval};
		LinkedList<int[]> ls = new LinkedList<int[]>();
		int[] curarr;
		int[] lastarr;
		boolean flag = false;							//���newInterval�Ƿ��Ѿ����뵽ls��
		for(int i = 0; i < intervals.length; i++) {
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
			
			if(!flag) {													//��newIntervalû�м��뵽ls��ʱ   д��if--else if��Ƕ��ifʡʱ
				if(newInterval[1] < curarr[0]) {                           
					ls.add(newInterval);
					flag = true;
				} else if(newInterval[0] < curarr[0]) {
					curarr[0] = newInterval[0];
					curarr[1] = Integer.max(newInterval[1], curarr[1]);
					flag = true;
				} else if(newInterval[0] <= curarr[1]) {
					curarr[1] = Integer.max(newInterval[1], curarr[1]);
					flag = true;
				}
				ls.add(curarr);
			} else {
				lastarr = ls.getLast();
				if(lastarr[1] >= curarr[0]) {
					lastarr[1] = Integer.max(lastarr[1], curarr[1]);
				} else {
					ls.add(curarr);
				}
			}
			
		}
		if(!flag)
			ls.add(newInterval);
		return ls.toArray(new int[ls.size()][2]);
    }

	
	public int[][] insert2(int[][] intervals, int[] newInterval) {
		LinkedList<int[]> ls = new LinkedList<int[]>();
		for(int[] curarr: intervals) {									//��Ϊ���ֽ���Ĵ���ʽ����һ���ģ����Կ��Լ򻯿��ǵ����Σ�Ҫô����Ҫô���ң�Ҫô���ص�
			if(newInterval == null || curarr[1] < newInterval[0]) {
				ls.add(curarr);
			} else if(curarr[0] > newInterval[1]) {
				ls.add(newInterval);
				ls.add(curarr);
				newInterval = null;										//��newInterval�Ƿ�Ϊnull����flag
			} else {													//���ڽ���ͳһ����newInterval���ؼ��ż���
				newInterval[0] = Math.min(newInterval[0], curarr[0]);
				newInterval[1] = Math.max(newInterval[1], curarr[1]);
			}
		}
		if(newInterval != null)
			ls.add(newInterval);
		return ls.toArray(new int[ls.size()][2]);
	}
	
}
