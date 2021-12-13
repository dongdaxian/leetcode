package nowcoder.huaweizhenti;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] orders = str.split(";");
        int[] dircetions = new int[4];
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('W', 1);
        map.put('S', 2);
        map.put('D', 3);
        for (String tmp: orders) {
            if (tmp.length() > 3 || tmp.length() < 2 || !map.containsKey(tmp.charAt(0))) {
                continue;
            }
            int num = 0;
            char ch = tmp.charAt(1);
            if(ch <= '9' && ch >= '0') {
                num = ch - '0';
            } else {
                continue;
            }
            if (tmp.length() > 2) {
                ch = tmp.charAt(2);
                if(ch <= '9' && ch >= '0') {
                    num = num * 10 + ch - '0';
                } else {
                    continue;
                }
            }
            dircetions[map.get(tmp.charAt(0))] += num;
        }
        int x = dircetions[3] - dircetions[0];
        int y = dircetions[1] - dircetions[2];
        System.out.println(x + "," + y);
    }

}
