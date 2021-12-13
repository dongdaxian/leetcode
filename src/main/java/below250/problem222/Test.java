package below250.problem222;

import java.util.LinkedList;
import java.util.List;

public class Test {
	public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        List<TreeNode> ls = new LinkedList<>();
        ls.add(root);
        int res = 0;
        while(!ls.isEmpty()){
            TreeNode temp = ls.remove(0);
            res++;
            if(temp.left != null)
                ls.add(temp.left);
            if(temp.right != null)
                ls.add(temp.right);
        }
        return res;
    }
	
	//方法一时间复杂度O(n)，空间复杂度O(n) (采用递归的方式，空间复杂度可以变为O(1))
	//二分查找时，每次O(h)，需要O(log2^h) = O(h)次，所以时间复杂度为O(h^2) = O((logn)^2)，空间复杂度为O(1) 
	public int countNodes2(TreeNode root) {
		if(root == null) return 0;
		int level = 0;
		TreeNode temp = root;
		while(temp.left != null) {
			level++;
			temp = temp.left;
		}
		int left = 1 << level, right = (1 << (level + 1)) - 1;
		while(left != right) {
			int mid = (right - left + 1) / 2 + left;
			if(exist(root, level, mid)) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
	
	public boolean exist(TreeNode root, int level, int target) {
		int bits = 1 << (level - 1);
		while(root != null && bits != 0) {
			if((bits & target) == 0) {
				root = root.left;
			} else {
				root = root.right;
			}
			bits >>= 1;
		}
		return root != null;
	}
}
