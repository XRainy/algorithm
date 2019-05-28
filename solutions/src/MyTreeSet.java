/**
 * @author : dx
 * @date : 2019/3/24
 * Description :
 */
public class MyTreeSet<T extends Comparable> {

    Node root;

    public class Node {
        T val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(T val) {
            this.val = val;
        }
    }

    public MyTreeSet() {

    }

    public void push(T val) {
        push(val, root);
    }

    private void push(T value, Node node) {
        if (root == null) {
            this.root = new Node(value);
            return;
        }

        if (value.compareTo(this.root.val) < 0) {
            node = node.left;
            push(value, node);
        }
        if (value.compareTo(this.root.val) > 0) {
            node = node.right;
            push(value, node);
        }
    }


}
