/**
 * @author : dx
 * @date : 2019/12/14
 * Description :
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode23合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int mid = lists.length - 1;
        while (mid != 0) {
            for (int i = 0; i <= mid / 2; i++) {
                lists[i] = mergeTwoSorts(lists[i], lists[mid - i]);
            }
            mid /= 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoSorts(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == listNode2) {
            return listNode1;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                temp.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                temp.next = listNode2;
                listNode2 = listNode2.next;
            }
            temp = temp.next;
        }
        if (listNode1 == null) {
            temp.next = listNode2;
        }
        if (listNode2 == null) {
            temp.next = listNode1;
        }
        return head.next;
    }
}
