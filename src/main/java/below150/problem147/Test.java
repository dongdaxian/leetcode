package below150.problem147;

public class Test {

    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE);

        while (head != null) {
            ListNode ptr = res;
            while (ptr.next != null && ptr.next.val < head.val) {
                ptr = ptr.next;
            }
            ListNode tmp = head.next;
            head.next = ptr.next;
            ptr.next = head;
            head = tmp;
        }

        return res.next;
    }

}
