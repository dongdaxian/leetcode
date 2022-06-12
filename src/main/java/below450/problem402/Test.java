package below450.problem402;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int[][] arr = new int[2][2];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 1;
        arr[1][1] = 1;
        Arrays.sort(arr, (int[] o1, int[] o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        System.out.println(arr[0][1]);
        System.out.println(arr[1][1]);
    }


    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char temp = num.charAt(i);
            if (stack.isEmpty() || stack.peek() <= temp || k == 0)
                stack.add(temp);
            else {
                stack.pop();
                i--;
                k--;
            }
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb = sb.reverse();
        int j = 0;
        for (; j < sb.length() && sb.charAt(j) == '0'; j++) ;
        String res = sb.substring(j);
        if (res.isEmpty())
            return "0";
        return res;
    }
}
