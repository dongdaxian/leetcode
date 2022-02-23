package nowcoder.jianzhi;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}


public class Solution8 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode ret = null;
        if (pNode.right != null) {
            ret = pNode.right;
            while (ret != null && ret.left != null) {
                ret = ret.left;
            }
        } else if (pNode.next != null && pNode.next.left == pNode) {
            ret = pNode.next;
        } else if (pNode.next != null && pNode.next.right == pNode) {
            while (pNode.next != null && pNode.next.right == pNode) {
                pNode = pNode.next;
            }
            ret = pNode.next;
        }
        return ret;
    }

}
