package below200.problem173;

import java.util.*;

public class BSTIterator {

    Iterator<Integer> iter;

    public BSTIterator(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ls.add(root.val);
                root = root.right;
            }
        }
        iter = ls.iterator();

    }

    public int next() {
        return iter.next();
    }

    public boolean hasNext() {
        return iter.hasNext();
    }
}
