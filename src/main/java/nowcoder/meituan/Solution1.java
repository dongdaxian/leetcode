package nowcoder.meituan;

import java.util.Scanner;

//美团2022.3.19
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int productNum = sc.nextInt();
        int[][] product = new int[productNum][2];
        for (int i = 0; i < productNum; i++) {
            product[i][0] = sc.nextInt();
        }
        for (int i = 0; i < productNum; i++) {
            product[i][1] = sc.nextInt();
        }
        int princpleNum = sc.nextInt();
        int[][] princple = new int[princpleNum][2];
        for (int i = 0; i < princpleNum; i++) {
            princple[i][0] = sc.nextInt();
        }
        for (int i = 0; i < princpleNum; i++) {
            princple[i][1] = sc.nextInt();
        }
        System.out.println(getOutPut(productNum, product, princpleNum, princple));
    }

    private static String getOutPut(int productNum, int[][] product, int princpleNum, int[][] princple) {
        StringBuilder res = new StringBuilder();
        int productRawPrice = 0;
        int productMinusPrice = 0;
        int princplePtr = -1;
        for (int ptr = 0; ptr < productNum; ptr++) {
            productRawPrice += product[ptr][0];
            productMinusPrice += product[ptr][1];
            int tmpPrice = productRawPrice;
            while (princplePtr + 1 < princpleNum && productRawPrice >= princple[princplePtr + 1][0]) {
                princplePtr++;
            }
            if (princplePtr > -1) {
                tmpPrice -= princple[princplePtr][1];
            }
            if (tmpPrice > productMinusPrice) {
                res.append('Z');
            } else if (tmpPrice < productMinusPrice) {
                res.append('M');
            } else {
                res.append('B');
            }

        }

        return res.toString();
    }

}
