package below1050.problem1024;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().videoStitching(new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}, 10));

	}
	public int videoStitching(int[][] clips, int T) {
		int[] times = new int[T + 1];
		//如果设置成Integer.MAX_VALUE-1的话，for循环体中不需要判断是否为-1，在返回时判断是否为Integer.MAX_VALUE-1
		//在返回时再判断的整体实现方式反而可能更精简，比如65题
        Arrays.fill(times, -1); 
        times[0] = 0;
        Arrays.sort(clips, (int[] a, int[] b) -> { return a[0] - b[0];});
        //也可用for(int i = 0; i <= T; i++){for(int[] temp: clips)}，时间复杂度为O(区间总长度 * 子区间数量)
        //现在的时间复杂度为O(子区间长度之和)，稍小
        for(int[] temp: clips){
        	if(temp[0] > T || times[temp[0]] == -1)
                break;
        	for(int i = temp[0] + 1; i <= temp[1] && i <= T; i++){
                times[i] = (times[i] == -1) ? times[temp[0]] + 1 : Math.min(times[temp[0]] + 1, times[i]);
            }
        }
        return times[T];
    }
}
