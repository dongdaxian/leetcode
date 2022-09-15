package below550.problem530;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        int pre = -1;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre >= 0)
                    min = Integer.min(min, Math.abs(root.val - pre));
                pre = root.val;
                root = root.right;
            }
        }
        return min;
    }


    public int getMinimumDifference2(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        int pre = -1;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (pre != -1) {
                res = Math.min(res, node.val - pre);
            }
            pre = node.val;
            node = node.right;
        }
        return res;
    }
}
