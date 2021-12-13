package below150.problem140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<>();
		ls.add("a");
		ls.add("aa");
		ls.add("aaa");
		ls.add("aaaa");
		ls.add("aaaaa");
//		ls.add("aaaaaa");
//		ls.add("aaaaaaa");
//		ls.add("aaaaaaaa");
//		ls.add("aaaaaaaaa");
//		ls.add("aaaaaaaaaa");
		System.out.println(new Test().wordBreak3("aaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", ls));
//		System.out.println(new Test().wordBreak3("aaaaaaaaaaaaaa", ls));
	}
	
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<List<String>> dpList = new ArrayList<>();
		for(int i = 0; i < s.length(); i++) {
			dpList.add(new ArrayList<>());
		}
		for(int i = 1; i <= s.length(); i++) {
			if(wordDict.contains(s.substring(0, i)))
				dpList.get(i - 1).add(s.substring(0, i));
			for(int j = 1; j < i; j++) {
				String temp = s.substring(j, i);
				if(dpList.get(j - 1).size() > 0 && wordDict.contains(temp)) {
					for(String tempSen: dpList.get(j - 1))
						dpList.get(i - 1).add(tempSen + " " + temp);
				}
			}
		}
		return dpList.get(s.length() - 1);
    }
	

	public List<String> wordBreak2(String s, List<String> wordDict) {
		Map<Integer, List<String>> map = new HashMap<>();
		map.put(0, new ArrayList<>());
		backtrack(s, s.length(), map, new HashSet<String>(wordDict));
		if(!map.containsKey(s.length())) return new ArrayList<>();
		return map.get(s.length());
	}
	
	//���仯����Ҫ����Ѿ�������Ľ�������������ռ�Ҳ�Ǽ�����Ľ����Ҳ��Ҫ���������������������ʱ�临�Ӷȣ���������汾
	public void backtrack(String s, int wordIndex, Map<Integer, List<String>> map, Set<String> wordDict) {
		if(map.containsKey(wordIndex)) return;
		for(int i = wordIndex - 1; i >= 0; i--) {
			String temp = s.substring(i, wordIndex);
			if(wordDict.contains(temp)) {
				backtrack(s, i, map, wordDict);
				List<String> ls = map.get(i);
				if(ls == null) continue;
				List<String> newLs = map.getOrDefault(wordIndex, new ArrayList<>());
				if(ls.size() == 0)
					newLs.add(temp);
				else {
					for(String tempSen: ls)
						newLs.add(tempSen + " " + temp);
				}
				map.put(wordIndex, newLs);
			}
		}
	}
	
	
	//�����ļ��仯����
	public List<String> wordBreak3(String s, List<String> wordDict) {
		Map<Integer, List<String>> map = new HashMap<>();
		backtrack2(s, s.length(), map, new HashSet<String>(wordDict));
		
		return map.get(s.length());
	}
	
	public void backtrack2(String s, int wordIndex, Map<Integer, List<String>> map, Set<String> wordDict) {
		if(map.containsKey(wordIndex) || wordIndex == 0) return;
		map.put(wordIndex, new ArrayList<>());
		for(int i = wordIndex - 1; i >= 0; i--) {
			String temp = s.substring(i, wordIndex);
			if(wordDict.contains(temp)) {
				backtrack2(s, i, map, wordDict);
				List<String> ls = map.get(i);
				List<String> newLs = map.get(wordIndex);
				if(ls == null)
					newLs.add(temp);
				else{
					for(String tempSen: ls)
						newLs.add(tempSen + " " + temp);
				}
				map.put(wordIndex, newLs);
			}
		}
	}
	
}
