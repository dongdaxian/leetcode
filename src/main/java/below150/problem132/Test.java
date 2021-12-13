package below150.problem132;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		System.out.println(new Test().minCut("aabaaca"));
	}
	public int minCut(String s) {
		char[] ch = s.toCharArray();
		boolean[][] dp = new boolean[s.length()][s.length()];
		for(int len = 0; len < s.length(); len++) {
			for(int beg = 0; beg + len < s.length(); beg++) {
//				dp[beg][beg + len] = (ch[beg] == ch[beg + len] && (len < 3 ? true : dp[beg + 1][beg + len - 1]));
				dp[beg][beg + len] = (ch[beg] == ch[beg + len] && (len < 3 || dp[beg + 1][beg + len - 1]));
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
//		return minCut(ch, dp, 0, map);
		
		return minCut2(ch, dp);
    }
	//用map记忆化搜索 自顶向下 用于递归中
	public int minCut(char[] ch, boolean[][] dp, int beg, Map<Integer, Integer> map) {
		if(beg == ch.length)
			return -1;
		if(map.containsKey(beg))
			return map.get(beg);
		int len = Integer.MAX_VALUE;
		for(int i = beg; i < ch.length; i++) {
			if(dp[beg][i]) {
				len = Integer.min(len, minCut(ch, dp, i + 1, map) + 1);			//永远不会出现返回MAX_VALUE的情况，因为最差情况都可以分成一个一个的
			}
		}
		map.put(beg, len);
		return len;
	}
	//用数组动态规划 自底向上
	public int minCut2(char[] ch, boolean[][] dp) {
		int[] min = new int[ch.length + 1];
		min[ch.length] = -1;
		for(int i = ch.length - 1; i > -1; i--) {
			int len = Integer.MAX_VALUE;
			for(int j = i; j < ch.length; j++) {
				if(dp[i][j]) {
					len = Integer.min(len, min[j + 1] + 1);
				}
			}
			min[i] = len;
		}
		return min[0];
	}
}
