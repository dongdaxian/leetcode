package below100.problem56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		int[][] intervals = new int[][]{{1,4},{4,5}};
		intervals = new Test().merge3(intervals);
		for(int i = 0; i < intervals.length; i++) {
			System.out.println(intervals[i][0] + " " + intervals[i][1]);
		}
	}
	
	public int[][] merge1(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}});

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int[] arr;
        Integer record = null;
        for(int i = 0; i < intervals.length; i++) {
        	arr = intervals[i];
        	
        	try{                                               
        		record = map.lastKey();
        	}catch (Exception e) {
        		record = null;
			}
        	
        	if(record != null && record >= arr[0]) {
        		if(record < arr[1]) {
	        		map.put(arr[1], map.get(record));
	        		map.remove(record);
        		}
        	}else {
        		map.put(arr[1], arr[0]);
        	}
        }
        
        int[][] res = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	res[i][0] = entry.getValue();
        	res[i][1] = entry.getKey();
        	i++;
        }
		return res;
    }
	
	
	public int[][] merge2(int[][] intervals) {
		if(intervals.length < 2) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}});

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int[] arr;
        Integer record = null;
        map.put(intervals[0][1], intervals[0][0]);          //先处理i=0，还可以通过判断i是否等于0，或者在每次循环结束前再给record赋值的方式
        for(int i = 1; i < intervals.length; i++) {         //其实对应for循环中对特殊情况的三种处理方式，在循环外单独处理，
        	arr = intervals[i];								//在循环内处理分为对应本次循环，和对应下次循环
        	record = map.lastKey();
        	if(record >= arr[0]) {
        		if(record < arr[1]) {
	        		map.put(arr[1], map.get(record));
	        		map.remove(record);
        		}
        	}else {
        		map.put(arr[1], arr[0]);
        	}
        }
        
        int[][] res = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	res[i][0] = entry.getValue();
        	res[i][1] = entry.getKey();
        	i++;
        }
		return res;
	}
	
	public int[][] merge3(int[][] intervals) {            //使用List一样可以存储一对数据，且更符合逻辑，因为这两个int并不是key和value的关系，
		if(intervals.length < 2) return intervals;		  //也更方便使用，一是往list中存数组引用，可以直接在外面改数组而不用再通过list把元素取出来，
        Arrays.sort(intervals, new Comparator<int[]>() {  //二是通过List的toArray转成数组很方便
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}});												
		
        
        List<int[]> ls = new ArrayList<int[]>();
        int[] pre = intervals[0];
        ls.add(pre);
        int[] cur;
        for(int i = 1; i < intervals.length; i++) {
        	cur = intervals[i];
        	if(cur[0] <= pre[1]) {
        		if(cur[1] > pre[1])
        			pre[1] = cur[1];
        	}else {
        		pre = cur;
        		ls.add(cur);
        	}
        }
		return ls.toArray(new int[ls.size()][2]);
	}

}
