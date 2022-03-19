package nowcoder.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int strLen = sc.nextInt();
        int operation = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        System.out.println(operateStr(str, operation));
    }

    private static String operateStr(String str, int operation) {
        if (operation == 1) {
            return encodeStr(str);
        } else {
            return decodeStr(str);
        }
    }

    private static String decodeStr(String str) {
        List<Character> output = new ArrayList<>();
        char[] ch = str.toCharArray();
        int strLen = str.length();
        for (int i = strLen - 1; i > -1; i--) {
            int index = (output.size() + 1 + 1) / 2 - 1;
            output.add(index, ch[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (char tmpChar : output) {
            sb.append(tmpChar);
        }
        return sb.toString();
    }

    private static String encodeStr(String str) {
        int strLen = str.length();
        List<Character> input = new ArrayList<>();
        for (int i = 0; i < strLen; i++) {
            input.add(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strLen; i++) {
            int tmpLen = input.size();
            int index = (tmpLen + 1) / 2 - 1;
            sb.append(input.remove(index));
        }
        return sb.toString();
    }
}
