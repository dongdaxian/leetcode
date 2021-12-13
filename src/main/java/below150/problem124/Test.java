package below150.problem124;

public class Test {

	int maxSun = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        computeSum(root);
        return maxSun;
    }

    public int computeSum(TreeNode root){
        if(root == null)
            return 0;
        int left = Integer.max(0, computeSum(root.left));
        int right = Integer.max(0, computeSum(root.right));
        maxSun = Integer.max(maxSun, root.val + left + right);
        
        return root.val + Integer.max(left, right);
    }
}
