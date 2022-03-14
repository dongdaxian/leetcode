package nowcoder.jianzhi;


import java.util.Objects;
import java.util.Stack;

public class Solution26 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (Objects.isNull(root1) || Objects.isNull(root2)) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root1;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (compare(cur, root2)) {
                    return true;
                }
                cur = cur.right;
            }
        }

        return false;
    }

    public boolean compare(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        boolean res = true;
        if (root2.left != null) {
            res = res && compare(root1.left, root2.left);
        }
        if (root2.right != null) {
            res = res && compare(root1.right, root2.right);
        }
        return res;
    }

}
