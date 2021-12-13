package below250.problem242;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            if(!map.containsKey(t.charAt(i)))
                return false;
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        for(Integer temp: map.values()){
            if(temp != 0)
                return false;
        }
        return true;
    }
	
	
	public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        //因为比较了长度，所以可以在此处优化
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
