package below100.problem92;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Test {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode mhead = new ListNode(0);
        mhead.next = head;
        ListNode lNode = null, rNode = null;
        ListNode tmp = mhead;
        for(int i = 0; i < left - 1; i++) {
            tmp = tmp.next;
        }
        lNode = tmp;
        for(int i = 0; i < right - left + 1; i++) {
            tmp = tmp.next;
        }
        rNode = tmp;
        tmp = lNode;
        while(lNode.next != rNode) {
            tmp = lNode.next.next;
            lNode.next.next = rNode.next;
            rNode.next = lNode.next;
            lNode.next = tmp;
        }
        return mhead.next;
    }
}
