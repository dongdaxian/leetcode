package below150.problem142;

import java.util.HashSet;

public class Test {

    public static void main(String[] args) {


    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        while (head != null && !hs.contains(head)) {
            hs.add(head);
            head = head.next;
        }
        return head;
    }

}
