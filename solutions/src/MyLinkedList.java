import java.util.Stack;

/**
 * @author : dx
 * @date : 2019/3/23
 * Description :
 */
public class MyLinkedList<T> {

    public Node head;

    public class Node {
        T value;
        Node next;

        Node(T value) {

        }

    }

    public void revert(Node head){
        Node node = head;
        Stack<Node> stack = new Stack();
        while(node != null){
            stack.push(node);
            node = node.next;
        }

        head = stack.pop();
        node = head;
        while(!stack.empty()){
            Node n = stack.pop();
            node.next = n;
            node = n;
        }
        node.next = null;
    }

    public void revert1(Node head){
        Node node1 = head;
        Node node2 = head;
        Node temp = null;
        while(node2 != null){
            node2 = node1.next;
            node1.next = temp;
            temp = node1;
            node1 = node2;
        }

    }

    public T getK(Node head, int k) {
        T t = null;
        Node node1 = head;
        Node node2 = head;
        int i = 0;
        while (node1 != null) {
            node1 = node1.next;
            if (i > k) {
                node2 = node2.next;
            }
            i++;
        }
        return node2.value;
    }

    public void addLast(T value) {
        Node node = head;
        if (head == null) {
            head = new Node(value);
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(value);
        }
    }

    public void get(int index) {

    }

    public void insert(T value, int index) {

    }

    public MyLinkedList() {

    }

}
