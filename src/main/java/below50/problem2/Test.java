package below50.problem2;


public class Test {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(6);
//		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(4);
//		l2.next.next = new ListNode(5);
//		l2.next.next.next = new ListNode(3);
		ListNode l = new Test().addTwoNumbers(l1, l2);
		while(l != null) {
			System.out.println(l.val);
			l = l.next;
		}

	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {      //�����l1��l2�Ľ�㣬�ǿ��ܻ���ֽ���������������������ѡ�񴴽����
		ListNode head = new ListNode(0), ptr = head;               
		int extra = 0;
		int res = 0;
		while(l1 != null || l2 != null || extra == 1) {							//Ҳ�����úϲ���������ķ�������һ�����������ͷ���ٴ�����ʣ�����������Ҫ��������ܶ�
			res += extra;
			extra = 0;
			if(l1 != null) {
				res += l1.val;
				l1 = l1.next;
			}
			if(l2 != null) {
				res += l2.val;
				l2 = l2.next;
			}
			if(res > 9) {
				extra = 1;
				res -= 10;
			}
			ptr.next = new ListNode(res);
			res = 0;
			ptr = ptr.next;
			
		}
		
		
		return head.next;
    }
	
	
}
