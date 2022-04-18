package below250.problem234;

import java.util.Stack;

public class Test {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode record = head;
        while (record != null) {
            ++len;
            record = record.next;
        }
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (i < len / 2) {
                st.push(head.val);
            } else if (i >= (len + 1) / 2) {
                if (head.val != st.pop())
                    return false;
            }
            head = head.next;
        }
        return true;
    }
}
