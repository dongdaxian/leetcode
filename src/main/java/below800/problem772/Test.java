package below800.problem772;

import java.util.Deque;
import java.util.LinkedList;

public class Test {

    private static int ptr = 0;

    public static void main(String[] args) {
//        System.out.print(calculate("1 + 1"));
//        System.out.print(calculate(" 6-4 / 2"));
//        System.out.print(calculate("2*(5+5*2)/3+(6/2+8)"));
        System.out.print(calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));

    }

    public static int calculate(String s) {
        String str = s.replaceAll(" ", "");
        return calculate(str, str.length());
    }

    public static int calculate(String s, int n) {
        Deque<Integer> stack = new LinkedList<>();
        int add = 1;
        int mulOrDiv = 0;
        while (ptr < n) {
            char ch = s.charAt(ptr);
            ptr++;
            switch (ch) {
                case '+':
                    add = 1;
                    break;
                case '-':
                    add = -1;
                    break;
                case '*':
                    mulOrDiv = 1;
                    break;
                case '/':
                    mulOrDiv = 2;
                    break;
                case '(':
                    addToStack(stack, calculate(s, n), add, mulOrDiv);
                    add = 1;
                    mulOrDiv = 0;
                    break;
                case ')':
                    int res = 0;
                    while (!stack.isEmpty()) {
                        res += stack.pop();
                    }
                    return res;
                default:
                    int num = ch - '0';
                    while (ptr < n && s.charAt(ptr) >= '0' && s.charAt(ptr) <= '9') {
                        num = num * 10 + s.charAt(ptr++) - '0';
                    }
                    addToStack(stack, num, add, mulOrDiv);
                    add = 1;
                    mulOrDiv = 0;
            }
        }
        return getStackRes(stack);
    }

    public static int getStackRes(Deque<Integer> stack) {
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void addToStack(Deque<Integer> stack, int num, int add, int mulOrDiv) {
        if (mulOrDiv == 0) {
            stack.push(add * num);
        } else if (mulOrDiv == 1) {
            stack.push(stack.pop() * add * num);
        } else {
            stack.push(stack.pop() / (add * num));
        }
    }
}
