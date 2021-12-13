package below50.problem30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String s = "wordgoodgoodgoodbestword";
		String[] words = new String[]{"word","good","best","good"};
		List<Integer> rs = new Test().findSubstring(s, words);
		for(Integer a: rs) {
			System.out.println(a);
		}

	}
	
	public List<Integer> findSubstring(String s, String[] words) {
		if(s == null || words == null || words.length == 0 || words[0].length() == 0) return null;
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		int slen = s.length(), arrlen = words.length, wordlen = words[0].length();
		for(int i = 0; i < arrlen; i++)
			map1.put(words[i], map1.getOrDefault(words[i], 0) + 1);
		List<Integer> rs = new ArrayList<Integer>();
		
		//时间复杂度是O(wordlen * (slen / wordlen))即O(slen)，有点KMP的意思，当发现匹配不了的时候，并不是直接清空map2，从能用的部分继续匹配
		for(int i = 0; i < wordlen; i++) {
			int count = 0;                                     					//记录加入map2的word个数
			for(int j = i, beg = i; j + wordlen <= slen; j += wordlen) {
				String temp = s.substring(j, j + wordlen);
				
				if(map1.containsKey(temp)) {
					while(map2.getOrDefault(temp, 0) + 1 > map1.get(temp)) {
						String begstr = s.substring(beg, beg + wordlen); 
						map2.put(begstr, map2.get(begstr) - 1);
						beg += wordlen;
						count--;
					}
					map2.put(temp, map2.getOrDefault(temp, 0) + 1);
					count++;
					if(count == arrlen) {
						rs.add(beg);
						count--;
						String begstr = s.substring(beg, beg + wordlen);
						map2.put(begstr, map2.get(begstr) - 1);
						beg += wordlen;						
					}
				}
				else {
					beg = j + wordlen;
					map2.clear();
					count = 0;
				}
			}
			map2.clear();
		}
		return rs;
    }
	

}
