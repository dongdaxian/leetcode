package below150.problem110;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(4);
        System.out.println(new Test().isBalanced2(root));
    }

    //记忆化搜索的子问题会重复计算多次，此处是递归，只是像记忆化搜索一样把结果保存了起来
    //本题返回的高度与是否平衡可以统一成一种格式
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        Map<TreeNode, Integer> map = new HashMap<>();
        getHeight(root, map);
        if (map.get(root) < 0) return false;
        return true;
    }

    public void getHeight(TreeNode root, Map<TreeNode, Integer> map) {
        if (root.left != null) getHeight(root.left, map);
        if (root.right != null) getHeight(root.right, map);
        int leftHeight = map.getOrDefault(root.left, 0);
        int rightHeight = map.getOrDefault(root.right, 0);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            map.put(root, -1);
        else
            map.put(root, Math.max(leftHeight, rightHeight) + 1);
    }

    //递归2
    public boolean isBalanced2(TreeNode root) {
//		if(height(root) >= 0)
//			return true;
//		return false;
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
