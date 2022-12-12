package basis;

import java.util.HashMap;

public class LRU {

    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put("key1", 1);
        lru.put("key2", 3);
        lru.put("key1", 2);
        lru.put("key3", 4);
        System.out.print(lru.get("key1"));
    }

    class Node {
        String key;
        int value;
        Node pre;
        Node next;
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<String, Node> map = new HashMap<>();
    private Node head, tail;
    private int count;
    private int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = new Node(null, 0);
        tail = new Node(null, 0);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
    }

    public void put(String key, int val) {
        Node node;
        if ((node = map.get(key)) != null) {
            node.value = val;
            moveToHead(node);
            return;
        }

        node = new Node(key, val);
        map.put(key, node);
        addNode(node);
        if (++count > capacity) {
            Node last = popTail();
            map.remove(last.key);
            --count;
        }
    }

    public int get(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    // 只处理链表位置
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}
