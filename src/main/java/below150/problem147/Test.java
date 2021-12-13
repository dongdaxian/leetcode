package below150.problem147;

public class Test {
	public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        while(head != null){
            ListNode temp = res;
            while(temp.next != null && temp.next.val < head.val)
                temp = temp.next;
            ListNode record = temp.next;
            temp.next = head;
            head = head.next;
            temp.next.next = record;
        }
        return res.next;
    }
}
