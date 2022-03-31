package below150.problem148;

public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode temp = new Test().sortList2(head);
        while (temp != null)
            System.out.println(temp.val);
    }

    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        ListNode tempHead1 = new ListNode(0);
        ListNode tempHead2 = new ListNode(0);
        ListNode temp1 = tempHead1, temp2 = tempHead2;

        for (ListNode ptr = head.next; ptr != null; ptr = ptr.next) {
            if (ptr.val >= head.val) {
                temp1.next = ptr;
                temp1 = temp1.next;
            } else {
                temp2.next = ptr;
                temp2 = temp2.next;
            }
        }
        temp1.next = null;
        temp2.next = null;
        tempHead1.next = sortList(tempHead1.next);
        tempHead2.next = sortList(tempHead2.next);
        ListNode ptr = tempHead2;
        for (; ptr.next != null; ptr = ptr.next) ;
        ptr.next = head;
        head.next = tempHead1.next;
        return tempHead2.next;
    }

    //自顶向下归并，递归
    public ListNode sortList2(ListNode head) {
        return sortList2(head, null);
    }

    public ListNode sortList2(ListNode head, ListNode tail) {
        if (head == null) return null;
        //单一节点
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fptr = head;
        ListNode sptr = head;
        while (fptr != tail) {
            sptr = sptr.next;
            fptr = fptr.next;
            if (fptr != tail)
                fptr = fptr.next;
        }
        ListNode l1 = sortList2(head, sptr);
        ListNode l2 = sortList2(sptr, tail);
        ListNode tempHead = new ListNode(0);
        ListNode temp = tempHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        } else if (l2 != null) {
            temp.next = l2;
        }
        return tempHead.next;
    }

    //自底向上归并，非递归
    public ListNode sortList3(ListNode head) {
        int len = 0;
        ListNode tempHead = new ListNode(0, head);
        while (head != null) {
            len++;
            head = head.next;
        }

        for (int mergeLen = 1; (mergeLen / 2) < len; mergeLen *= 2) {
            ListNode ptr = tempHead.next;
            ListNode curr = tempHead;
            while (ptr != null) {
                ListNode l1 = ptr;
                for (int i = 0; i < mergeLen - 1 && ptr != null; i++)
                    ptr = ptr.next;
                ListNode l2 = null;
                if (ptr != null) {
                    l2 = ptr.next;
                    ptr.next = null;
                    ptr = l2;
                }
                for (int i = 0; i < mergeLen - 1 && ptr != null; i++)
                    ptr = ptr.next;
                if (ptr != null) {
                    ListNode temp = ptr.next;
                    ptr.next = null;
                    ptr = temp;
                }
                curr.next = merge(l1, l2);
                while (curr.next != null)
                    curr = curr.next;
            }
        }
        return tempHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
