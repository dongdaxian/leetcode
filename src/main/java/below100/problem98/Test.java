package below100.problem98;

import java.util.Stack;

public class Test {
    public TreeNode t = null;//方法3要使用的变量，起c++中全局变量的作用

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(20);
        System.out.println(new Test().isValidBST3(root));
    }

    //中序遍历
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
			return true;
		}
        Stack<TreeNode> st = new Stack<>();
        int val = Integer.MIN_VALUE;
//		while(root != null || !st.isEmpty()) {
//			while(root != null) {
//				st.add(root);
//				root = root.left;
//			}
//			root = st.pop();
//			if(root.val <= val)
//				return false;
//			val = root.val;
//			root = root.right;
//		}
        while (root != null || !st.isEmpty()) {        //不嵌套循环的形式
            if (root != null) {
                st.add(root);
                root = root.left;
            } else {
                root = st.pop();
                if (root.val <= val)
                    return false;
                val = root.val;
                root = root.right;
            }
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST2(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
			return true;
		}
        if (root.val <= minValue || root.val >= maxValue) {
			return false;
		}
        return isValidBST2(root.left, minValue, root.val) && isValidBST2(root.right, root.val, maxValue);
    }

    //中序遍历的递归做法
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
			return true;
		}
        if (isValidBST3(root.left)) {
            if (t != null && root.val <= t.val) {
				return false;
			}
            t = root;
            return isValidBST3(root.right);
        }
        return false;
    }
}
