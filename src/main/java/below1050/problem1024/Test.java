package below1050.problem1024;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().videoStitching(new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}, 10));

	}
	public int videoStitching(int[][] clips, int T) {
		int[] times = new int[T + 1];
		//������ó�Integer.MAX_VALUE-1�Ļ���forѭ�����в���Ҫ�ж��Ƿ�Ϊ-1���ڷ���ʱ�ж��Ƿ�ΪInteger.MAX_VALUE-1
		//�ڷ���ʱ���жϵ�����ʵ�ַ�ʽ�������ܸ����򣬱���65��
        Arrays.fill(times, -1); 
        times[0] = 0;
        Arrays.sort(clips, (int[] a, int[] b) -> { return a[0] - b[0];});
        //Ҳ����for(int i = 0; i <= T; i++){for(int[] temp: clips)}��ʱ�临�Ӷ�ΪO(�����ܳ��� * ����������)
        //���ڵ�ʱ�临�Ӷ�ΪO(�����䳤��֮��)����С
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
