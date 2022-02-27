package below100.problem86;

public class Test {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode temp1 = l1, temp2 = l2;
        for (ListNode temp = head; temp != null; ) {
            if (temp.val >= x) {
                temp2.next = temp;
                temp = temp.next;
                temp2 = temp2.next;
                temp2.next = null;
            } else {
                temp1.next = temp;
                temp = temp.next;
                temp1 = temp1.next;
                temp1.next = null;
            }
        }
        temp1.next = l2.next;
        return l1.next;
    }

}
