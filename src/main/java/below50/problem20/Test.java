package below50.problem20;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(new Test().isValid(s));
    }

    public boolean isValid(String s) {
        String temp = "";
        char ch1 = 0, ch2 = 0;
        for (int i = 0; i < s.length(); i++) {
            ch1 = s.charAt(i);
            if (ch1 == '[' || ch1 == '(' || ch1 == '{')
                temp = temp.concat(String.valueOf(ch1));
            else {
                if (temp.isEmpty()) return false;
                ch2 = temp.charAt(temp.length() - 1);
                if ((ch2 == '(' && ch1 == ')')
                        || (ch2 == '[' && ch1 == ']')
                        || (ch2 == '{' && ch1 == '}'))
                    temp = temp.substring(0, temp.length() - 1);
                else
                    break;
            }
        }
        if (temp.isEmpty())
            return true;
        return false;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

}
