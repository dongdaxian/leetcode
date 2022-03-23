package below150.problem143;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        List<ListNode> ls = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null) {
            ls.add(ptr);
            ptr = ptr.next;
        }
        int size = ls.size();
        for (int i = 0; i < (size - 1) / 2; i++) {
            ListNode temp = head.next;
            head.next = ls.remove(ls.size() - 1);
            head.next.next = temp;
            head = temp;
        }
        if (size % 2 == 0)
            head.next.next = null;
        else
            head.next = null;

    }
}
