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
	
	//����һʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n) (���õݹ�ķ�ʽ���ռ临�Ӷȿ��Ա�ΪO(1))
	//���ֲ���ʱ��ÿ��O(h)����ҪO(log2^h) = O(h)�Σ�����ʱ�临�Ӷ�ΪO(h^2) = O((logn)^2)���ռ临�Ӷ�ΪO(1) 
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
