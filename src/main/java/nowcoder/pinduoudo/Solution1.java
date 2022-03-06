package nowcoder.pinduoudo;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(encodeStr(str));
    }

    private static String encodeStr(String str) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int count = 0;
        while (index < str.length()) {
            if (count == 0 || str.charAt(index) == str.charAt(index - 1)){
                count++;
                index++;
            } else {
                sb.append(count).append(str.charAt(index - 1));
                count = 0;
            }
        }
        sb.append(count).append(str.charAt(str.length() - 1));
        return sb.toString();
    }

}
