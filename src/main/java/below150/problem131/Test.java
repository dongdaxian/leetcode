package below150.problem131;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<List<String>> res = new Test().partition2("ababababababababababababcbabababababababababababa");
		for(List<String> ls: res) {
			for(String temp: ls)
				System.out.print(temp + " ");
			System.out.println();
		}
	}
//	dfs
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> ls = new ArrayList<>();
		char[] ch = s.toCharArray();
		partition(ch, res, ls, 0);
		return res;
    }
	public void partition(char[] ch, List<List<String>> res, List<String> ls, int beg) {
		if(beg == ch.length)
			res.add(new ArrayList<>(ls));
		for(int i = beg; i < ch.length; i++) {
			if(isPalindrome(ch, beg, i)) {
				ls.add(String.valueOf(ch, beg, i - beg + 1));
				partition(ch, res, ls, i + 1);
				ls.remove(ls.size() - 1);
			}
		}
	}
	public boolean isPalindrome(char[] ch, int beg, int end) {
		int i = beg, j = end;
		while(i < j) {
			if(ch[i] == ch[j]) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}

	//判定是否是回文时，对同一个小问题可能重复计算，所以可以动态规划，但与之前不同之处在于，最终结果并不在dp中，数组dp用于辅助得出最终结果
	public List<List<String>> partition2(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> ls = new ArrayList<>();
		char[] ch = s.toCharArray();
		boolean[][] dp = new boolean[ch.length][ch.length];
		for(int len = 0; len < ch.length; len++) {
			for(int beg = 0, end = beg + len; end < ch.length; beg++, end++) {
				if(len < 3) {
					if(ch[beg] == ch[end])
						dp[beg][end] = true;
				} else {
					if(ch[beg] == ch[end] && dp[beg + 1][end - 1])
						dp[beg][end] = true;
				}
			}
		}		
		partition2(ch, res, ls, 0, dp);
		return res;
    }
	
	//此处是回溯，用bfs会比较麻烦
	//这个部分其实也可以用动态规划/记忆化搜索的思想，见132题
	public void partition2(char[] ch, List<List<String>> res, List<String> ls, int beg, boolean[][] dp) {
		if(beg == ch.length)
			res.add(new ArrayList<>(ls));
		for(int i = beg; i < ch.length; i++) {
			if(dp[beg][i]) {
				ls.add(String.valueOf(ch, beg, i - beg + 1));
				partition2(ch, res, ls, i + 1, dp);
				ls.remove(ls.size() - 1);
			}
		}
		
	}
	
	
}
