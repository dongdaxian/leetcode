package below1400.problem1356;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {

	}
	
	public int[] sortByBits(int[] arr) {
		int[][] darr = new int[arr.length][2];
		for(int j = 0; j < arr.length; j++) {
			String binstr = Integer.toBinaryString(arr[j]);
			int count = 0;
			for(int i = 0; i < binstr.length(); i++) {
				if(binstr.charAt(i) == '1')
					count++;
			}
			darr[j][0] = count;
			darr[j][1] = arr[j]; 
		}
		
		Arrays.sort(darr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
		});
		
		for(int i = 0; i < arr.length; i++)
			arr[i] = darr[i][1];
		return arr;
    }
}
