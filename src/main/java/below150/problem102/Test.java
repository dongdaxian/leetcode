package below150.problem102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = null;
        root.right.left = null;
        root.right.right = new TreeNode(4);

        List<List<Integer>> res = new Test().levelOrder(root);
        for (List<Integer> ls : res) {
            for (int k : ls)
                System.out.print(k);
            System.out.println();
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.pollFirst();
                if (temp != null) {
                    ls.add(temp.val);
                    queue.addLast(temp.left);
                    queue.addLast(temp.right);
                }
            }
            if (!ls.isEmpty())
                res.add(new ArrayList<>(ls));
            ls.clear();
        }
        return res;
    }

}
