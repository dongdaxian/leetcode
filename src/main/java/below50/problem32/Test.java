package below50.problem32;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		String s = "()(()";
		System.out.println(new Test().longestValidParentheses3(s));
	}
	
	public int longestValidParentheses1(String s) {
		boolean[] exist = new boolean[s.length()];                  //��¼����ȥ��'('��index
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
	
	public int longestValidParentheses2(String s) {  //Ҫô������ȥ�����ȫ��¼��ջ�У�Ҫô��¼������ȥ����ţ�����һrecֻ��¼��û����ȥ�Ĳ�����ţ�������������Ϣû��ʹ��
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

	public int longestValidParentheses3(String s) {  //ԭ�������������ַ��������ƥ�䳤�ȣ�����ֻ��Ҫ����ÿ���±괦��ƥ�䳤�ȣ�������һ�������ֵ���ɣ����������
		int[] longest = new int[s.length() + 1];     //ת��Ϊ����ÿ���±괦��ƥ�䳤�ȣ�������������Ի��ֳ�С�����ҿ���ʹ��С����Ľ��������ʹ�ö�̬�滮��˼��
//		for(int i = 0; i < s.length(); i++) {        
//			if(s.charAt(i) == ')' && i > 0)									 //longest[i]��ʾ����i���������ַ��������ƥ�䳤��
		for(int i = 1; i < s.length(); i++) {        
			if(s.charAt(i) == ')')					    				     //i = 0��������ÿ��ǣ�Ҳ����ȥ�����⴦����һ��
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
	}												//��ʵ������ʹ��ջҲ������Ϊ�Ƕ�̬�滮��ԭ�������������ַ��������ƥ�䳤�ȣ�����ֻ��Ҫ���ÿ��������ȥ���������
													//������������ֵ���ɣ����������ת��Ϊ������ȥ��������ţ�����������Ϳ���ʹ��С����Ľ��
}
