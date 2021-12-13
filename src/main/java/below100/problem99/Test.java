package below100.problem99;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);
		midOrder(root);
		new Test().recoverTree2(root);
		System.out.println();
		midOrder(root);
	}
	
	public void recoverTree(TreeNode root) {
        List<TreeNode> nodels = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null) {			//嵌套while的方法
        	while(temp != null) {
        		stack.push(temp);
        		temp = temp.left;
        	}
        	temp = stack.pop();
        	nodels.add(temp);
        	temp = temp.right;
        }
        int size = nodels.size(); 
        for(int i = 1; i < size; i++) {						//选择排序
        	int ival = nodels.get(i).val;
        	int j = i - 1;
        	for(; j > -1 && ival < nodels.get(j).val; j--) {			
        		nodels.get(j + 1).val = nodels.get(j).val;
        	}
        	nodels.get(j + 1).val = ival;
        }
    }
	
	//只有两个元素交换了位置，所以交换这个操作只需要O(n)，可以放在中序遍历中
	public void recoverTree2(TreeNode root) {
		TreeNode pre = null, fnode = null, snode = null;
		Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null) {			//不用嵌套while的方法
        	while(temp != null) {
        		stack.push(temp);
        		temp = temp.left;
        	}
        	temp = stack.pop();
        	if(pre != null && pre.val > temp.val) {
        		if(fnode == null) {
        			fnode = pre;
        			snode = temp;
        		} else {
        			snode = temp;
        			break;
        		}
        	}
        	pre = temp;
        	temp = temp.right;
        }
        int record = fnode.val;
        fnode.val = snode.val;
        snode.val = record;
		
	}
	
	public static void midOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null) {
        	while(temp != null) {
        		stack.push(temp);
        		temp = temp.left;
        	}
        	temp = stack.pop();
        	System.out.print(temp.val + " ");
        	temp = temp.right;
        }
	}
}
