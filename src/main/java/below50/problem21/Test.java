package below50.problem21;

public class Test {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        ListNode record = new Test().mergeTwoLists(l1, l2);
        while (record != null) {
            System.out.println(record.val);
            record = record.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), ptr = head;
//		ListNode record
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ptr.next = l1;
                ptr = ptr.next;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                ptr = ptr.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) ptr.next = l2;
        else if (l2 == null) ptr.next = l1;
        return head.next;
    }

}
