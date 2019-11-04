/**
 * @author : dx
 * @date : 2019/6/22
 * Description :
 * 描述
 * 中文
 * English
 * 给定一个排序链表，删除所有重复的元素只留下原链表中没有重复的元素。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 给出 1->2->3->3->4->4->5->null，返回 1->2->5->null
 * <p>
 * 给出 1->1->1->2->3->null，返回 2->3->null
 */
public class 删除排序链表中的重复数字 {

    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode result = null;
        ListNode temp = null;
        ListNode tempPre = null;
        while (head != null) {
            boolean isDelete = false;

            ListNode listNodeNext = head.next;
            while (listNodeNext != null) {
                if (head.val == listNodeNext.val) {
                    isDelete = true;
                    listNodeNext = listNodeNext.next;
                } else {
                    head.next = listNodeNext;
                    break;
                }
            }

            if (isDelete) {
                head = head.next;
                if(head == null){
                    temp.next = null;
                }
            } else {
                if (result == null) {
                    result = head;
                    temp = head;
                } else {
                    temp.next = head;
                    tempPre = temp;
                    temp = temp.next;
                }
                head = head.next;
            }
        }
        return result;
    }
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }

        return dummy.next;
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
