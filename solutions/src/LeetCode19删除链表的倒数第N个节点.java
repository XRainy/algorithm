/**
 * @author : dx
 * @date : 2019/12/2
 * Description :
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode19删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int i = 0;
        while (i < n) {
            temp = temp.next;
            i++;
        }
        if (temp == null) {
            return head.next;
        }
        ListNode start = head;
        while (temp.next != null) {
            temp = temp.next;
            start = start.next;
        }
        start.next = start.next.next;
        return head;
    }
}
