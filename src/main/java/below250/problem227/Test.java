package below250.problem227;

import java.util.Stack;

public class Test {

    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for(char tmp: s.toCharArray()) {
            if(tmp != ' ')
                sb.append(tmp);
        }
        return calculate(sb.toString().toCharArray(), sb.length());
    }

    public int calculate(char[] ch, int n) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int i = 0;
        while(i < n) {
            int tmp = 0;
            while(i < n && '0' <= ch[i] && ch[i] <= '9') {
                tmp = tmp * 10 + ch[i] - '0';
                i++;
            }
            switch(sign) {
                case '+':
                    stack.push(tmp);
                    break;
                case '-':
                    stack.push(-tmp);
                    break;
                case '*':
                    stack.push(stack.pop() * tmp);
                    break;
                default:
                    stack.push(stack.pop() / tmp);
            }
            if(i < n)
                sign = ch[i++];
        }
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
