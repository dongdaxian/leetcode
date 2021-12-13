package below100.problem76;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().minWindow("ADOBECODEBANC", "ABC"));

	}
	
	public String minWindow(String s, String t) {	//与30题一样，都是滑动窗口的思想，当匹配成功时不是直接清空当前map，而只是清理部分接着用剩下部分
		if(s == null || s.length() < t.length() || s.length() == 0)	return "";
		
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c: t.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		
		int left = 0, right = Integer.MAX_VALUE;
		int left_ptr = 0, right_ptr = 0;
		int count = 0;
		for(right_ptr = 0; right_ptr < s.length(); right_ptr++) {
			if(!map.containsKey(s.charAt(right_ptr)))
				continue;
			map.put(s.charAt(right_ptr), map.get(s.charAt(right_ptr)) - 1);
			if(map.get(s.charAt(right_ptr)) > -1)
				count++;
				
			while(count == t.length()) {
				if(right_ptr - left_ptr < right - left) {
					right = right_ptr;
					left = left_ptr;
				}
				if(map.containsKey(s.charAt(left_ptr))) {
					map.put(s.charAt(left_ptr), map.get(s.charAt(left_ptr)) + 1);
					if(map.get(s.charAt(left_ptr)) > 0)
						count--;
				}
				left_ptr++;
			}
		}
		if(right == Integer.MAX_VALUE) return "";
		return s.substring(left, right + 1);
    }

}
