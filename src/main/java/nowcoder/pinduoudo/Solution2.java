package nowcoder.pinduoudo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        for (int i = 0; i < Integer.parseInt(num); i++) {
            String desc = sc.nextLine();
            int changeTimes = Integer.parseInt(desc.split(" ")[0]);
            String str = sc.nextLine();
            System.out.println(getDiffStrNum(str, changeTimes));
        }

    }

    private static int getDiffStrNum(String str, int changeTimes) {
        if (changeTimes == 0) {
            return 1;
        }
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                break;
            }
            i++;
            j--;
        }
        if (i < j) {
            return 2;
        }
        return 1;

    }

}
