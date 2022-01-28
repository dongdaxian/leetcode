package below50.problem23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        ListNode[] arr = new ListNode[]{l1, l2, l3};
        ListNode ptr = new Test().mergeKLists(arr);
        while (ptr != null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        ListNode head = new ListNode(0), ptr = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                pq.add(lists[i]);
        ListNode temp = null;
        while (!pq.isEmpty()) {
            temp = pq.poll();
            ptr.next = temp;
            ptr = ptr.next;
            temp = temp.next;
            if (temp != null)
                pq.add(temp);
        }
        return head.next;
    }

}
