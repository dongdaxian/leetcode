package below350.problem331;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().isValidSerialization("1,#,#,#,1"));
    }

    public boolean isValidSerialization(String preorder) {
        String[] val = preorder.split(",");
        int stack = 1;
        for (String tmp : val) {
            if (!tmp.equals("#")) {
                if (stack <= 0)
                    return false;
                stack++;
            } else {
                stack--;
            }
        }
        return stack == 0;
    }

    public boolean isValidSerialization2(String preorder) {
        String[] val = preorder.split(",");
        Deque<Pair<String, Integer>> stack = new LinkedList<>();
        if (!val[0].equals("#")) {
            stack.push(new Pair<>(val[0], 2));
        } else {
            return val.length == 1;
        }

        for (String str : val) {
            if (stack.isEmpty()) {
                return false;
            }
            if (str.equals("#")) {
                while (!stack.isEmpty() && stack.peek().getValue() == 1) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek().getValue() == 2) {
                    String tmp = stack.pop().getKey();
                    stack.push(new Pair<>(tmp, 1));
                }
            } else {
                stack.push(new Pair<>(str, 2));
            }
        }

        return stack.isEmpty();
    }
}
