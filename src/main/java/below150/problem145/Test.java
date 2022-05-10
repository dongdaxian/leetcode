package below150.problem145;

import java.util.*;

public class Test {

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode prev = null;
        while (!Objects.isNull(root) || !stack.isEmpty()) {
            while (!Objects.isNull(root)) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }


    public List<Integer> postorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack1 = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            res.add(0, root.val);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }

        return res;
    }


}
