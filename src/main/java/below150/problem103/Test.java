package below150.problem103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> ls = new LinkedList<>();
        ls.offer(root);
        boolean reverse = false;
        while(!ls.isEmpty()){
            int size = ls.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = ls.poll();
                temp.add(node.val);
                if(node.left != null)
                    ls.add(node.left);
                if(node.right != null)
                    ls.add(node.right);
            }
            if(reverse){
                Collections.reverse(temp);
            }
            res.add(temp);
            reverse = !reverse;
            
        }
        return res;
    }
}
