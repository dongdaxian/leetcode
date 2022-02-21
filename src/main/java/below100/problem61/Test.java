package below100.problem61;

public class Test {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode ptr = head;
        int count = 1;
        while (ptr.next != null) {
            count++;
            ptr = ptr.next;
        }
        k = k % count;
        ListNode ret = new ListNode(0);
        if (k != 0) {
            ListNode tmp = head;
            for (int i = 0; i < count - k - 1; i++) {
                tmp = tmp.next;
            }
            ret.next = tmp.next;
            tmp.next = null;
            ptr.next = head;
        } else {
            ret.next = head;
        }
        return ret.next;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode ptr = head;
        int count = 1;
        while (ptr.next != null) {
            count++;
            ptr = ptr.next;
        }
        ptr.next = head;
        k = k % count;
        for (int i = 0; i < count - k; i++) {
            head = head.next;
            ptr = ptr.next;
        }
        ptr.next = null;
        return head;
    }
}
