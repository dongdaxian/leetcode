package below150.problem129;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(9);
		root.right.left = null;
		root.right.right = null;
		System.out.println(new Test().sumNumbers(root));
	}

//	bfs
	public int sumNumbers(TreeNode root) {
		if(root == null) return 0;
		LinkedList<TreeNode> ls = new LinkedList<>();
		ls.addLast(root);
		int sum = 0;
		while(!ls.isEmpty()) {
			int size = ls.size();
			for(int i = 0; i < size; i++) {
				TreeNode temp = ls.pollFirst();
				boolean flag = false;
				if(temp.left != null) {
					temp.left.val += 10 * temp.val;
					ls.addLast(temp.left);
					flag = true;
				}
				if(temp.right != null) {
					temp.right.val += 10 * temp.val;
					ls.addLast(temp.right);
					flag = true;
				}
				if(!flag) {
					sum += temp.val;
				}
			}
		}
		
		return sum;
    }
	//dfs
	public int sumNumbers2(TreeNode root) {
		return sum(root, 0);
	}

	//一般递归思路是用x乘返回值，在本题不适用，所以很可能会漏掉递归的这种解法
	public int sum(TreeNode root, int sum) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return sum * 10 + root.val;
		return sum(root.left, root.val + sum * 10) + sum(root.right, root.val + sum * 10);
	}
	

}
