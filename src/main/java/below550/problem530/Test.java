package below550.problem530;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getMinimumDifference(TreeNode root) {
		int min = Integer.MAX_VALUE;
		int pre = -1;
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || root != null) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				if(pre >= 0)
					min = Integer.min(min, Math.abs(root.val - pre));
				pre = root.val;
				root = root.right;
			}
		}
		return min;
    }
}
