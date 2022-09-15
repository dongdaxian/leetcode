package below250.problem224;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
    int ptr = 0;

    public static void main(String[] args) {
        System.out.println(new Test().calculate("(1+(4 +5+ 2) -3)+(6+8)"));
    }

    public int calculate(char[] ch, int n) {
        int res = 0;
        while (ptr < n) {
            int flag = 1;
            if (ch[ptr] == '-') {
                flag = -1;
                ptr++;
            } else if (ch[ptr] == '+') {
                flag = 1;
                ptr++;
            } else if (ch[ptr] == ')') {
                ptr++;
                return res;
            }
            if (ch[ptr] == '(') {
                ptr++;
                res += flag * calculate(ch, n);
            } else {
                int tmp = 0;
                while (ptr < n && ch[ptr] <= '9' && ch[ptr] >= '0') {
                    tmp = tmp * 10 + ch[ptr] - '0';
                    ptr++;
                }
                res += flag * tmp;
            }
        }

        return res;
    }

    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for (char tmp : s.toCharArray()) {
            if (tmp != ' ')
                sb.append(tmp);
        }
        return calculate(sb.toString().toCharArray(), sb.length());
    }

    public int calculate2(String s) {
        //对于以括号划分的表达式，ops存储它们起始符号
        Deque<Boolean> ops = new LinkedList<>();
        ops.push(true);

        int ret = 0;
        boolean flag = true;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                flag = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                flag = !ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(flag);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += (flag ? 1 : -1) * num;
            }
        }
        return ret;
    }
}
