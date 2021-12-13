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
}
