package below50.Problem19;

public class Test {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head = new Test().removeNthFromEnd(head, 2);
		while(head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
		
	}
	//加上头节点，可以少考虑 return head.next;这种情况
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ptr = head;
		ListNode preptr = head;
		for(int i = 0; i < n; i++)
			ptr = ptr.next;
		if(ptr == null) return head.next;
		while(ptr.next != null) {
			ptr = ptr.next;
			preptr = preptr.next;
		}
		preptr.next = preptr.next.next;
		return head;
			
    }

}
