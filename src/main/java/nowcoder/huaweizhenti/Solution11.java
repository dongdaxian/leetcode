package nowcoder.huaweizhenti;

import java.util.Scanner;

public class Solution11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0) {
            System.out.println(0);
            return;
        }
        while (num != 0) {
            System.out.print(num % 10);
            num = num / 10;
        }
    }
}
