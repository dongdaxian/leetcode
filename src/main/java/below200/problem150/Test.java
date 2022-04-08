package below200.problem150;

import java.util.Stack;

public class Test {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String tmp : tokens) {
            if (!tmp.equals("+") && !tmp.equals("-") && !tmp.equals("*") && !tmp.equals("/")) {
                stack.push(Integer.valueOf(tmp));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int res = 0;
//                用switch
                if (tmp.equals("+")) {
                    res = a + b;
                } else if (tmp.equals("-")) {
                    res = b - a;
                } else if (tmp.equals("*")) {
                    res = b * a;
                } else {
                    res = b / a;
                }
                stack.push(res);
            }
        }
        return stack.peek();
    }
}
