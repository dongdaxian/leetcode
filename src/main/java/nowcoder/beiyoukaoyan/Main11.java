package nowcoder.beiyoukaoyan;

import java.util.Scanner;

public class Main11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int num = sc.nextInt();
			TreeNode root = new TreeNode(sc.nextInt());
			for(int k = 0; k < num - 1; k++) {
				TreeNode temp = new TreeNode(sc.nextInt());
				insertNode(root, temp);
			}
			preOrder(root);
			System.out.println();
			midOrder(root);
			System.out.println();
			postOrder(root);
			System.out.println();
		}
	}
	private static void postOrder(TreeNode root) {
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}
	private static void midOrder(TreeNode root) {
		if(root == null) return;
		midOrder(root.left);
		System.out.print(root.val + " ");
		midOrder(root.right);
	}
	private static void preOrder(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
		
	}
	public static void insertNode(TreeNode root, TreeNode temp) {
		if(root.val == temp.val)
			return;
		if(root.val < temp.val) {
			if(root.right == null)
				root.right = temp;
			else
				insertNode(root.right, temp);
		} else {
			if(root.left == null)
				root.left = temp;
			else
				insertNode(root.left, temp);
		}
	}
	
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}
