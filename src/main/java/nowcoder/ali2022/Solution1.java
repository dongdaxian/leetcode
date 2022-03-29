package nowcoder.ali2022;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            String input = sc.nextLine();
            String res;
            if (input.length() < 6 || input.length() > 12) {
                res = "illegal length";
            } else if (!ischaracterLegal(input)) {
                res = "illegal charactor";
            } else if (set.contains(input)) {
                res = "acount existed";
            } else {
                set.add(input);
                res = "registration complete";
            }
            System.out.println(res);
        }
    }

    private static boolean ischaracterLegal(String input) {
        char[] chAry = input.toCharArray();
        for (char ch : chAry) {
            if (!(ch <= 'z' && ch >= 'a') && !(ch <= 'Z' && ch >= 'A')) {
                return false;
            }
        }
        return true;
    }

}
