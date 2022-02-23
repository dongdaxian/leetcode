package below100.problem82;

public class Test {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fn = new ListNode(0);
        ListNode ptr = fn;
        while(head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
            if(head != null && head.val == tmp.val) {
                while(head != null && head.val == tmp.val) {
                    head = head.next;
                }
            } else {
                ptr.next = tmp;
                ptr = ptr.next;
            }
        }
        return fn.next;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode left = node;
        ListNode mid = node.next;
        ListNode right = node.next;
        while (right != null) {
            while (right != null && mid.val == right.val) {
                right = right.next;
            }
            if (mid.next != right) {
                left.next = right;
            } else {
                left = mid;
            }
            mid = right;
        }

        return node.next;
    }
}
