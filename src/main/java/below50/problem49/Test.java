package below50.problem49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String[] inpu = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = new Test().groupAnagrams(inpu);
		for(List<String> temp: res) {
			for(String str: temp)
				System.out.print(str + " ");
			System.out.println();
		}

	}
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for(String str: strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String temp = String.valueOf(ch);
			if(map.containsKey(temp)) {
				map.get(temp).add(str);
			} else {
				List<String> toadd = new ArrayList<>();
				toadd.add(str);
				map.put(temp, toadd);
			}
		}
		return new ArrayList<>(map.values());
    }

}
