package below1000.problem968;

public class Test {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(0);
		System.out.println(new Test().minCameraCover(root));
	}
	
	//动态规划都是自底向上，此处是先用dfs到达树的底部
	public int minCameraCover(TreeNode root) {
		int[] cameras = dfs(root);
		return cameras[1];
    }
	
	public int[] dfs(TreeNode root) {
		if(root == null)
			return new int[] {Integer.MAX_VALUE/2, 0, 0};
		int[] lsides = dfs(root.left);
		int[] rsides = dfs(root.right);
		int aside = lsides[2] + rsides[2] + 1;
		int bside = Integer.min(aside, Integer.min(lsides[0] + rsides[1], lsides[1] + rsides[0]));
		int cside = Integer.min(aside, lsides[1] + rsides[1]);
		return new int[] {aside, bside, cside};
	}

}
