/**
 * @author : dx
 * @date : 2019/7/11
 * Description :
 * 35. 翻转链表
 * 中文English
 * 翻转一个链表
 *
 * 样例
 * 样例 1:
 *
 * 输入: 1->2->3->null
 * 输出: 3->2->1->null
 * 样例 2:
 *
 * 输入: 1->2->3->4->null
 * 输出: 4->3->2->1->null
 * 挑战
 * 在原地一次翻转完成
 */
public class 翻转链表 {
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
