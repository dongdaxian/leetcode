package nowcoder.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int len = sc.nextInt();
        int[] tags = new int[len];
        for (int i = 0; i < len; i++) {
            tags[i] = sc.nextInt();
        }
        char[] ch = line.toCharArray();
        Map<Integer, int[]> offset = new HashMap<>();
        for (int i = 0; i < ch.length;) {
            int tag = getNum(ch[i]) * 16 + getNum(ch[++i]);
            int strLen = getNum(ch[++i]) * 16 + getNum(ch[++i]);
            i++;
            if (i + strLen * 2 > ch.length) {
                break;
            }
            offset.put(tag, new int[]{strLen, i / 2});
            i = i + strLen * 2;
        }
        for (int tmp : tags) {
            if (offset.containsKey(tmp)) {
                System.out.println(offset.get(tmp)[0] + " " + offset.get(tmp)[1]);
            } else {
                System.out.println("0 0");
            }
        }
    }

    public static int getNum(char ch) {
        if ('9' >= ch && ch >= '0') {
            return ch - '0';
        } else {
            return ch - 'A' + 10;
        }
    }
}
