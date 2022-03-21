package nowcoder.jianzhi;

import java.util.Deque;
import java.util.LinkedList;

public class Solution31 {

    public boolean IsPopOrder(int [] pushA, int [] popA) {
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int tmp : popA) {
            while (true) {
                if (!stack.isEmpty() && stack.peek() == tmp) {
                    stack.pop();
                    break;
                } else {
                    if (j == popA.length) {
                        return false;
                    }
                    stack.push(pushA[j++]);
                }
            }
        }
        return true;
    }
}
