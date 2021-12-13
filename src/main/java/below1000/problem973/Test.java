package below1000.problem973;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		new Test().kClosest3(new int[][] {{3, 3}, {5, -1}, {-2, 4}}, 2);
	}
	
	//时间复杂度O(nlogn)
	public int[][] kClosest(int[][] points, int K) {
		int[][] compare = new int[points.length][2];
		for(int i = 0; i < points.length; i++) {
			compare[i][0] = (int)(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
			compare[i][1] = i;
		}
		Arrays.sort(compare, (int[] o1, int[] o2) -> {return o1[0] - o2[0];});
		int[][] res = new int[K][2];
		for(int i = 0; i < K; i++) {
			int index = compare[i][1];
//			res[i][0] = points[index][0];
//			res[i][1] = points[index][1];
			res[i] = points[index];
		}
		return res;
    }
	
	//使用PriorityQueue时，把所有元素加入队列的时间复杂度为O(nlogn)，但是由于本题只要前k个，那么可以只维护一个只有k个元素的大根堆，时间复杂度为O(nlogk)
	public int[][] kClosest2(int[][] points, int K) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> {return o2[0] - o1[0];});
		for(int i = 0; i < K; i++)
			queue.offer(new int[] {points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
		for(int i = K; i < points.length; i++) {
			int temp = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			if(temp < queue.peek()[0]) {
				queue.remove();
				queue.offer(new int[] {temp, i});
			}
		}
		int[][] res = new int[K][2];
		int size = queue.size();
		for(int i = 0; i < size; i++) {
			res[i] = points[queue.remove()[1]];
		}
		return res;
	}
	
	//快排思想，时间复杂度O(n)
	public int[][] kClosest3(int[][] points, int K) {
		if(K == 0) return null;
		int[][] temp = new int[points.length][2];
		for(int i = 0; i < points.length; i++)
			temp[i] = new int[] {points[i][0] * points[i][0] + points[i][1] * points[i][1], i};
		
		quickSort(temp, 0, temp.length - 1, K);
		int[][] res = new int[K][2];
		for(int i = 0; i < K; i++) {
			res[i] = points[temp[i][1]];
		}
		return res;
	}
	
	public void quickSort(int[][] arr, int left, int right, int k) {
		
		int[] temp = arr[left];
		int lptr = left, rptr = right;
		while(lptr < rptr) {
			while(lptr < rptr && arr[rptr][0] >= temp[0])
				rptr--;
			arr[lptr] = arr[rptr];
			while(lptr < rptr && arr[lptr][0] <= temp[0])
				lptr++;
			arr[rptr] = arr[lptr]; 
			
		}
		//如果采用arr[][]来赋值而不是修改引用，会导致错误
		arr[lptr] = temp;
		if(lptr - left + 1 == k) {
			return;
		} else if(lptr - left + 1 < k) {
			quickSort(arr, lptr + 1, right, k - lptr + left - 1);
		} else {
			quickSort(arr, left, lptr - 1, k);
		}
	}
	
}
