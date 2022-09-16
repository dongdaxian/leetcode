package nowcoder.ant;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] ch = line.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int res = 0;
        for (int i = 0; i < ch.length; i++) {
            count ^= 1 << (ch[i] - 'a');
            /*
            * ch[i:j]中某个字符的出现次数，等于在ch[0:j]中出现次数减去ch[0:i-1]中出现次数。如果ch[i:j]中某个字符出现的次数为偶数，当且仅
            * 当它在ch[0:j]和ch[0:i−1]中出现次数均为奇数或者均为偶数，也就是0:j对应的count和0:i−1对应的count在该位置相同。因此，
            * 如果ch[i:j]是一个符合条件子串，那么0:j对应的count和0:i−1对应的count最多只有一位不同，即出现次数为唯一奇数的那个数字
            * */

            for (int j = 0; j < 26; j++) {
                int tmp = count ^ (1 << j);
                res += map.getOrDefault(tmp, 0);
            }
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        System.out.print(res);
    }


}
