/**
 * @author : dx
 * @date : 2019/7/11
 * Description :
 * 描述
 * 中文
 * English
 * 翻转链表中第m个节点到第n个节点的部分
 * <p>
 * m，n满足1 ≤ m ≤ n ≤ 链表长度
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 例1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 输出: 1->4->3->2->5->NULL.
 * 例2:
 * <p>
 * 输入: 1->2->3->4->NULL, m = 2 and n = 3,
 * 输出: 1->3->2->4->NULL.
 * 挑战
 * Reverse it in-place and in one-pass
 */
public class 翻转链表2 {
    /**
     * @param head: ListNode head is the head of the linked list
     * @param m:    An integer
     * @param n:    An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (m == n) {
            return head;
        }
        int a = 1;
        ListNode result = head;
        ListNode listNode1End = head;
        ListNode listNode2Start = head;
        ListNode listNode2End = head;
        ListNode listNode3Start = head;
        while (head != null) {

            if (a + 1 == m) {
                listNode1End = head;
                head = head.next;
            }
            if (a == m) {
                listNode2End = head;
            }
            if (a >= m && a <= n) {
                ListNode listNode = head;
                head = head.next;
                listNode.next = listNode2Start;
                listNode2Start = listNode;
            }
            if (a == n + 1) {
                listNode3Start = head;
                break;
            }
            a++;
        }
        listNode1End.next = listNode2Start;
        listNode2End.next = listNode3Start;
        return result;
    }


    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode result = null;
        while (head != null) {
            ListNode listNode = head;
            head = head.next;
            listNode.next = result;
            result = listNode;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
