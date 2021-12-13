package below100.problem83;

public class Test {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode fn = new ListNode(0, head);
        ListNode tmp = head;
        while(tmp.next != null) {
            if(tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return fn.next;
    }

}
