package below150.problem144;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {

    }

    //比对94题
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
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

    //父节点先于子节点或晚于子节点被输出，如前序、后序遍历，可以使用该方法
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            root = st.pop();
            res.add(root.val);
            if (root.right != null) {
                st.add(root.right);
            }
            if (root.left != null) {
                st.add(root.left);
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || !Objects.isNull(root)) {
            while (root != null) {
                res.add(root.val);
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            root = root.right;
        }
        return res;
    }
}
