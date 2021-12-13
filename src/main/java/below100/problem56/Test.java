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
        map.put(intervals[0][1], intervals[0][0]);          //�ȴ���i=0��������ͨ���ж�i�Ƿ����0��������ÿ��ѭ������ǰ�ٸ�record��ֵ�ķ�ʽ
        for(int i = 1; i < intervals.length; i++) {         //��ʵ��Ӧforѭ���ж�������������ִ���ʽ����ѭ���ⵥ������
        	arr = intervals[i];								//��ѭ���ڴ����Ϊ��Ӧ����ѭ�����Ͷ�Ӧ�´�ѭ��
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
	
	public int[][] merge3(int[][] intervals) {            //ʹ��Listһ�����Դ洢һ�����ݣ��Ҹ������߼�����Ϊ������int������key��value�Ĺ�ϵ��
		if(intervals.length < 2) return intervals;		  //Ҳ������ʹ�ã�һ����list�д��������ã�����ֱ��������������������ͨ��list��Ԫ��ȡ������
        Arrays.sort(intervals, new Comparator<int[]>() {  //����ͨ��List��toArrayת������ܷ���
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
