package problem232;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> fst;
    Stack<Integer> sst;
    /** Initialize your data structure here. */
    public MyQueue() {
        fst = new Stack<>();
        sst = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        fst.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!sst.isEmpty()) {
            return sst.pop();
        } else {
            while(!fst.isEmpty()) {
                sst.push(fst.pop());
            }
            return sst.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(!sst.isEmpty()) {
            return sst.peek();
        } else {
            while(!fst.isEmpty()) {
                sst.push(fst.pop());
            }
            return sst.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return fst.isEmpty() && sst.isEmpty();
    }
}
