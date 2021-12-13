package below150.problem144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		
	}
	//±»∂‘94Ã‚
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		while(!st.isEmpty() || root != null) {
			if(root != null) {
				st.add(root);
				res.add(root.val);
				root = root.left;
			} else {
				root = st.pop();
				root = root.right;
			}
		}
		return res;
    }
	
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		st.add(root);
		while(!st.isEmpty()) {
			root = st.pop();
			res.add(root.val);
			if(root.right != null) {
				st.add(root.right);
			}
			if(root.left != null) {
				st.add(root.left);
			}
		}
		return res;
    }
	
	
}
