package below1050.problem1006;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        int i = N - 1;
        while (i > 0) {
            stack.push(stack.pop() * i);
            if (--i == 0)
                break;
            stack.push(stack.pop() / i);
            if (--i == 0)
                break;
            stack.push(i);
            if (--i == 0)
                break;
            stack.push(-i);
            i--;
        }
        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }
        return ret;
    }

    public int clumsy2(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }

}
