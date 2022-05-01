package nowcoder.tencent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
 }

public class Solution4 {

    public static void main(String[] args) {
        ListNode[] ary = new ListNode[3];
        ary[0] = new ListNode(10);
        ary[0].next = new ListNode(2);
        ary[0].next.next = new ListNode(3);
        ary[1] = new ListNode(7);
        ary[1].next = new ListNode(4);
        ary[1].next.next = new ListNode(5);
        ary[1].next.next.next = new ListNode(1);
        ary[1].next.next.next.next = new ListNode(10);
        ary[2] = new ListNode(3);
        ary[2].next = new ListNode(7);
        ary[2].next.next = new ListNode(4);
        ListNode ls = new Solution4().solve(ary);
        System.out.println(ls.val);
    }

    public ListNode solve (ListNode[] a) {
        // write code here
        Map<Integer, ListNode> map = new HashMap<>();

        for (ListNode node : a) {
            map.putIfAbsent(node.val, node);
            while (node.next != null) {
                ListNode pre = map.get(node.val);
                map.putIfAbsent(node.next.val, node.next);
                pre.next = map.get(node.next.val);
                node = node.next;
            }
        }
        ListNode head = map.get(a[0].val);
        ListNode res = head;
        ListNode ptr = head.next;
        while (ptr !=  head) {
            if (ptr.val < res.val) {
                res = ptr;
            }
            ptr = ptr.next;
        }
        return res;
    }
    
}
