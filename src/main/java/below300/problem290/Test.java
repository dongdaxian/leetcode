package below300.problem290;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

    }

    public boolean wordPattern(String pattern, String s) {
        String[] sary = s.split(" ");
        if (pattern.length() != sary.length)
            return false;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String temp = sary[i];
            if (!map1.containsKey(ch) && !map2.containsKey(temp)) {
                map1.put(ch, temp);
                map2.put(temp, ch);
            } else if (!map1.containsKey(ch) || !map2.containsKey(temp) || !map1.get(ch).equals(temp) || !map2.get(temp).equals(ch)) {
                return false;
            }
        }
        return true;
    }

}
