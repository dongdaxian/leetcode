package below1050.problem1047;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public String removeDuplicates(String S) {
        ThreadPoolExecutor tpe;
        Stack<Character> stack = new Stack<>();
        char[] ch = S.toCharArray();
        for(char tmp: ch) {
            if(stack.isEmpty() || !stack.peek().equals(tmp)) {
                stack.push(tmp);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
