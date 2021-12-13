package below50.problem24;

import below50.problem24.ListNode;

public class Test {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(2);
//		l1.next.next.next = new ListNode(3);
		l1 = new Test().swapPairs(l1);
		while(l1 != null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}

	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode start = new ListNode(0);
		ListNode ptr = head;
		start.next = head;
		
		for(ListNode temp = start; ptr != null && ptr.next != null; ptr = ptr.next, temp = temp.next.next) {
			temp.next = ptr.next;
			ptr.next = ptr.next.next;
			temp.next.next = ptr;
			
		}
		return start.next;
    }
	

}
