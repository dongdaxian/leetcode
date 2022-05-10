package below350.problem328;

public class Test {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode oddTemp = oddHead, evenTemp = evenHead;
        int i = 0;
        //也可以改成每次放入两个节点，这样可以不用i来判断奇偶
        while (head != null) {
            if (i % 2 == 0) {
                evenTemp.next = head;
                evenTemp = evenTemp.next;
            } else {
                oddTemp.next = head;
                oddTemp = oddTemp.next;
            }
            head = head.next;
            i++;
        }
        oddTemp.next = null;
        evenTemp.next = oddHead.next;
        return evenHead.next;
    }
}
