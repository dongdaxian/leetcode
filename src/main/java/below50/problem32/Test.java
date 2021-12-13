package below50.problem32;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		String s = "()(()";
		System.out.println(new Test().longestValidParentheses3(s));
	}
	
	public int longestValidParentheses1(String s) {
		boolean[] exist = new boolean[s.length()];                  //记录能消去的'('的index
		Stack<Integer> rec = new Stack<Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				rec.push(i);
			} else if(rec.size() != 0) {
				exist[rec.pop()] = true;
			}
		}
		int slen = 0, tlen = 0;
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				if(exist[i])
					st.push(i);
				else {
					slen = slen >= tlen ? slen : tlen;
					tlen = 0;
				}
				
			}
			else if(!st.isEmpty()) {
				tlen++;
				st.pop();
			}
			else {
				slen = slen >= tlen ? slen : tlen;
				tlen = 0;
			}
		}
		slen = slen >= tlen ? slen : tlen;
		return slen * 2;
    }
	
	public int longestValidParentheses2(String s) {  //要么把能消去的序号全记录在栈中，要么记录不能消去的序号，方法一rec只记录了没能消去的部分序号，导致序号这个信息没法使用
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(')
				st.push(i);
			else if(st.isEmpty() || s.charAt(st.peek()) == ')')
				st.push(i);
			else
				st.pop();
		}
		if(st.isEmpty()) return s.length();
		int longest = 0;
		int temp1 = s.length();
		int temp2 = 0;
		while(!st.isEmpty()) {
			temp2 = st.pop();
			longest = longest >= (temp1 - temp2 - 1) ? longest : (temp1 - temp2 - 1);
			temp1 = temp2;
		}
		longest = longest >= temp1 ? longest : temp1;
		return longest;
	}

	public int longestValidParentheses3(String s) {  //原问题是求整个字符串的最大匹配长度，我们只需要求在每个下标处的匹配长度，最后遍历一次求最大值即可，这样问题就
		int[] longest = new int[s.length() + 1];     //转化为求在每个下标处的匹配长度，这样大问题可以划分成小问题且可以使用小问题的结果，可以使用动态规划的思想
//		for(int i = 0; i < s.length(); i++) {        
//			if(s.charAt(i) == ')' && i > 0)									 //longest[i]表示以在i处结束的字符串的最大匹配长度
		for(int i = 1; i < s.length(); i++) {        
			if(s.charAt(i) == ')')					    				     //i = 0的情况不用考虑，也就舍去了特殊处理这一步
				if(s.charAt(i - 1) == ')' && i - 1 - longest[i] >= 0 && s.charAt(i - 1 - longest[i]) == '(') {
					longest[i + 1] = longest[i] + 2;
					if(i - 2 - longest[i] >= 0)
						longest[i + 1] += longest[i - 1 - longest[i]];
				} else if(s.charAt(i - 1) == '(') {
					longest[i + 1] = longest[i - 1] + 2;
				}
		}
		
		int maxInt = 0;
		for(int temp: longest) {
			maxInt = Integer.max(maxInt, temp);
		}
		
		return maxInt;
	}												//其实方法二使用栈也可以认为是动态规划。原问题是求整个字符串的最大匹配长度，我们只需要求出每个不能消去的括号序号
													//最后遍历求最大差值即可，这样问题就转化为求不能消去的括号序号，这样大问题就可以使用小问题的结果
}
