import java.math.BigDecimal;

/**
 * 假定用链表表示两个数，其中每个节点仅包含一个数字。假设这两个数的数字顺序排列，请设计一种方法将两个数相加，并将其结果表现为链表的形式。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入: 6->1->7   2->9->5
 * 输出: 9->1->2
 * 样例 2:
 * <p>
 * 输入: 1->2->3   4->5->6
 * 输出: 5->7->9
 */

public class 链表求和 {
    /**
     * * 假定用链表表示两个数，其中每个节点仅包含一个数字。假设这两个数的数字顺序排列，请设计一种方法将两个数相加，并将其结果表现为链表的形式。
     * * <p>
     * * 样例
     * * 样例 1:
     * * <p>
     * * 输入: 6->1->7   2->9->5
     * * 输出: 9->1->2
     * * 样例 2:
     * * <p>
     * * 输入: 1->2->3   4->5->6
     * * 输出: 5->7->9
     *
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null || l2 == null) {
            return null;
        }
        String s1 = "";
        String s2 = "";
        ListNode temp = l1;
        while (temp != null) {
            s1 += temp.val;
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            s2 += temp.val;
            temp = temp.next;
        }
        BigDecimal BigDecimal1 = new BigDecimal(s1);
        BigDecimal BigDecimal2 = new BigDecimal(s1);
        String result = BigDecimal1.add(BigDecimal2).toString();
        ListNode resultList = new ListNode(result.charAt(0));
        ListNode tempNode = resultList;
        for (int i = 1; i < result.length(); i++) {
            tempNode.next = new ListNode(result.charAt(i));
            tempNode = temp.next;

        }
        return resultList;
    }

    /**
     * @param head
     * @return * 给定单链表，将所有奇数节点连接在一起，然后将偶数节点连接在一起。 请注意，这里我们讨论的是节点编号，而不是节点中的值。
     * * <p>
     * * 样例
     * * 样例1:
     * * <p>
     * * 输入： 1->2->3->4->5->NULL
     * * 输出： 1->3->5->2->4->NULL
     * * 样例2:
     * * <p>
     * * 输入： 2->1->null
     * * 输出： 2->1->null
     * * 注意事项
     * * 奇数节点和偶数节点的相对位置应当不变。
     * * 第一个节点应为奇数，第二个节点为偶数，以此类推……
     */
    public ListNode oddEvenList(ListNode head) {
        // write your code here
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddList = head;
        ListNode evenList = head.next;
        ListNode oddTemp = oddList;
        ListNode evenTemp = evenList;
        head = head.next.next;
        int i = 0;
        while (head != null) {
            if (i % 2 == 0) {
                oddTemp.next = head;
                oddTemp = oddTemp.next;
            } else {
                evenTemp.next = head;
                evenTemp = evenTemp.next;
            }
            head = head.next;
            i++;
        }
        evenTemp.next = null;
        oddTemp.next = evenList;
        return oddList;

    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
