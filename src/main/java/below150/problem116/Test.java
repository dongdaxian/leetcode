package below150.problem116;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        Queue<Node> st = new LinkedList<>();
        st.add(root);
        while (!st.isEmpty()) {
            int size = st.size();
            Node pre = new Node(0);
            Node temp = null;
            for (int i = 0; i < size; i++) {
                if ((temp = st.poll()) == null)
                    break;
                temp.next = null;
                st.add(temp.left);
                st.add(temp.right);
                pre.next = temp;
                pre = temp;
            }
        }
        return root;
    }
}
