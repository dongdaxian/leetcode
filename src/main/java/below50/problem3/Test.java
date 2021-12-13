package below50.problem3;

import java.util.HashMap;

public class Test {
	public static void main(String[] args) {

	}
	
	public int lengthOfLongestSubstring(String s) {
		int len = 0;
		int currentLen = 0;
		boolean[] ifExist = new boolean[26];
		for(int i = 0; i < s.length(); i++) {
			if(!ifExist[s.charAt(i) - 'a']) {
				currentLen++;
				ifExist[s.charAt(i) - 'a'] = true;
			} else {
				len = Math.max(len, currentLen);
				ifExist[s.charAt(i - currentLen) - 'a'] = false;
				--currentLen;
				--i;
			}
		}
		len = Math.max(len, currentLen);
		return len;
    }
	
}
