package nowcoder.jianzhi;

import java.util.HashMap;
import java.util.Map;

public class Solution35 {

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        RandomListNode r5 = new RandomListNode(5);
        r1.next = r2;r1.random = r3;
        r2.next = r3;r2.random = r5;
        r3.next = r4;r3.random = null;
        r4.next = r5;r4.random = r2;
        r5.next = null;r5.random = null;
        RandomListNode head = new Solution35().Clone2(r1);
        System.out.println(head.label);

    }

    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode, Integer> inputMap = new HashMap<>();
        Map<Integer, RandomListNode> resMap = new HashMap<>();
        int pos = 0;
        while (pHead != null) {
            inputMap.put(pHead, pos);
            resMap.put(pos, new RandomListNode(pHead.label));
            pos++;
            pHead = pHead.next;
        }
        inputMap.entrySet().stream().forEach(entry -> {
            RandomListNode pre = entry.getKey();
            RandomListNode node = resMap.get(inputMap.get(entry.getKey()));
            if (pre.next != null) {
                node.next = resMap.get(inputMap.get(pre.next));
            } else {
                node.next = null;
            }
            if (pre.random != null) {
                node.random = resMap.get(inputMap.get(pre.random));
            } else {
                node.random = null;
            }
        });

        return resMap.get(0);
    }

    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode record = pHead;
        //Java是引用拷贝，不会有效率问题
        //非值类型，不用重写hashcode()
        Map<RandomListNode, RandomListNode> resMap = new HashMap<>();
        while (pHead != null) {
            resMap.put(pHead, new RandomListNode(pHead.label));
            pHead = pHead.next;
        }
        pHead = record;
        while (pHead != null) {
            RandomListNode node = resMap.get(pHead);
            node.next = resMap.get(pHead.next);
            node.random = resMap.get(pHead.random);
            pHead = pHead.next;
        }

        return resMap.get(record);
    }
}
