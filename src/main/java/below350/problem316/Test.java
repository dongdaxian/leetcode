package below350.problem316;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
					set.remove(sb.charAt(sb.length() - 1));
					sb.deleteCharAt(sb.length() - 1);
                }
                set.add(ch);
                sb.append(ch);
            }
            count[ch - 'a']--;
        }

        return sb.toString();

    }

}
