package nowcoder.tencent;


import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        System.out.println(new Solution3().getPos(input));
    }

    public int getPos(String solider) {
        long w = 0;
        char[] ch = solider.toCharArray();
        long v = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                v += i + 1;
            }
        }
        long res = v - w;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0') {
                w += i + 1;
            } else {
                v -= i + 1;
            }
            if (Math.abs(v - w) > res) {
                break;
            }
            res = Math.abs(v - w);
        }
        return (int)res;
    }

}
