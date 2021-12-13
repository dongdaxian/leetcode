package below50.problem25;

public class Test {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(0);
		node1.next = new ListNode(1);
		node1.next.next = new ListNode(2);
		node1.next.next.next = new ListNode(3);
		node1.next.next.next.next = new ListNode(4);
		ListNode node2 = new Test().reverseKGroup(node1, 3);
		while(node2 != null){
			System.out.println(node2.val);
			node2 = node2.next;
		}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode ptr = new ListNode(0);
		ptr.next = head;
		head = ptr;
		
		ListNode slow = head.next, fast = head.next;
		ListNode record;
		while(fast != null){    

//			for(int i = 0; i < k - 1; i++){
//				fast = fast.next;
//				if(fast == null) break;
//			}
//			if(fast == null) break;
			for(int i = 0; i < k - 1 && fast != null; i++)  //更优美的方式
				fast = fast.next;
			if(fast == null) break;
			
//			_record = slow;
//			record = fast.next;
			record = slow;  							   //更优美的方式
			
			for(int i = 0; i < k - 1; i++) {
				ptr.next = slow.next;
				slow.next = fast.next;
				fast.next = slow;
				slow = ptr.next;
			}
			
//			slow = record;
//			fast = record;
//			ptr = _record;
			slow = fast = record.next;                    //更优美的方式
			ptr = record;
		}
		
			
		return head.next;
    }

}
