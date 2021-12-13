package below800.problem767;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(new Test().reorganizeString("aab"));
	}
	
	//基于最大堆的贪心算法
	public String reorganizeString(String S) {
		if(S == null || S.isEmpty())
			return "";
		int[] charr = new int[26];
		int max = 0;
		for(char ch: S.toCharArray()) {
			charr[ch - 'a']++;
			max = Math.max(max, charr[ch - 'a']);
		}
		PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> {return o2[1] - o1[1];});
		for(int i = 0; i < 26; i++) {
			if(charr[i] > 0) {
				queue.add(new int[] {i, charr[i]});
			}
		}
		int len = S.length();
		if((len + 1) / 2 < max)
			return "";
		StringBuilder sb = new StringBuilder();
		while(queue.size() > 1) {
			int[] temp1 = queue.poll();
			int[] temp2 = queue.poll();
			sb.append((char)(temp1[0] + 'a'));
			sb.append((char)(temp2[0] + 'a'));
			temp1[1]--;
			temp2[1]--;
			if(temp1[1] > 0)
				queue.add(temp1);
			if(temp2[1] > 0)
				queue.add(temp2);
		}
		if(!queue.isEmpty())
			sb.append((char)(queue.poll()[0] + 'a'));
		return sb.toString();
    }
	
	//基于计数的贪心算法,方法一的最大堆其实是利用计数建了一个最大堆
	public String reorganizeString2(String S) {
		if(S == null || S.isEmpty())
			return "";
		int[] count = new int[26];
		int maxCount = 0;
		for(char ch: S.toCharArray()) {
			count[ch - 'a']++;
			maxCount = Math.max(maxCount, count[ch - 'a']);
		}
		int length = S.length();
		if(maxCount > (length + 1) / 2)
			return "";
		int oddIndex = 1, evenIndex = 0;
		char[] res = new char[length];
		for(int i = 0; i < 26; i++) {
			char c = (char)(i + 'a');
			//count较小优先在奇数下标分配，可以用count[i] < (length + 1) / 2
			while(count[i] > 0 && count[i] <= length / 2 && oddIndex < length) {
				count[i]--;
				res[oddIndex] = c;
				oddIndex += 2;
			}
			//不用再验证evenIndex < length
			while(count[i] > 0) {
				count[i]--;
				res[evenIndex] = c;
				evenIndex += 2;
			}
		}
		return String.valueOf(res);
	}
}
