package nowcoder.jianzhi;


import java.util.*;


public class Solution7 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new Solution7().reConstructBinaryTree2(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        System.out.println(root.val);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        return constructBinaryTree(pre, 0, vin, 0, vin.length - 1);
    }


    public TreeNode constructBinaryTree(int[] pre, int preLeft, int[] vin, int vinLeft, int vinRight) {
        if (vinLeft > vinRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int index = vinLeft;
        while (vin[index] != pre[preLeft]) {
            index++;
        }
        root.left = constructBinaryTree(pre, preLeft + 1, vin, vinLeft, index - 1);
        root.right = constructBinaryTree(pre, preLeft + (index - vinLeft) + 1, vin, index + 1, vinRight);
        return root;
    }

    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        if (pre.length == 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        //前序的第一个其实就是根节点
        TreeNode root = new TreeNode(pre[0]);
        TreeNode cur = root;
        for (int i = 1, j = 0; i < pre.length; i++) {
            // 在前序遍历中相邻的两个数字：要么后一个是前一个的左节点；要么后一个是前一个的右节点或者其祖先的右节点
            if (cur.val != in[j]) {
                // 后一个是前一个的左节点
                stack.push(cur);
                cur = cur.left = new TreeNode(pre[i]);
            } else {
                // 后一个是前一个的右节点或者其祖先的右节点
                j++;
                // 利用中序来弹出栈中节点，直至找到pre[i]父节点
                while (!stack.empty() && stack.peek().val == in[j]) {
                    cur = stack.pop();
                    j++;
                }
                // 此时in[j]是pre[i]对应的右子树的最下层左节点
                cur = cur.right = new TreeNode(pre[i]);
            }
        }
        return root;
    }

}
