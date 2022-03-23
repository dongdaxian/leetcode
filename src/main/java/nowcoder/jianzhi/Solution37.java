package nowcoder.jianzhi;


import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution37 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        String str = new Solution37().Serialize2(root);
        System.out.println(str);

        TreeNode newRoot = new Solution37().Deserialize2(str);
        System.out.println(newRoot.val);
    }

    //前序。用 # 代表空子树，结构可反推出（中序、后序同理）
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(' ');
        sb.append(Serialize(root.left)).append(' ');
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    private int index = 0;

    TreeNode Deserialize(String str) {
        String[] vals = str.split(" ");
        return deserialize(vals);
    }

    TreeNode deserialize(String[] vals) {
        if (vals[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[index++]));
        node.left = deserialize(vals);
        node.right = deserialize(vals);
        return node;
    }

    //层次
    String Serialize2(TreeNode root) {
        List<String> ls = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                ls.add("#");
            } else {
                ls.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return StringUtils.join(ls, " ");
    }
    TreeNode Deserialize2(String str) {
        String[] vals = str.split(" ");
        if (vals[0].equals("#")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode ret = new TreeNode(Integer.parseInt(vals[0]));
        queue.offer(ret);
        int i = 1;
        while (i < vals.length) {
            TreeNode root = queue.poll();;
            String val = vals[i];
            if (!val.equals("#")) {
                root.left = new TreeNode(Integer.parseInt(val));
                queue.offer(root.left);
            }
            i++;
            val = vals[i];
            if (!val.equals("#")) {
                root.right = new TreeNode(Integer.parseInt(val));
                queue.offer(root.right);
            }
            i++;
        }
        return ret;
    }

}
