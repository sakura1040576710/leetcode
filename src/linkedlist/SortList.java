package linkedlist;

import java.io.IOException;
import java.util.List;

public class SortList {

    public static void main(String[] args) throws IOException {
        ListNode head = LinkedListIO.input();
//        head = sortList(head);
        head = sortList2(head);
        LinkedListIO.output(head);
        LinkedListIO.destroy();
    }

    /**
     * 归并 自底向上
     * @param head
     * @return
     */
    private static ListNode sortList2(ListNode head) {
        int length = getListLength(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int step = 1; step < length; step *= 2) {
            ListNode newListTail = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur;
                ListNode head2 = splitList(head1, step);
                cur = splitList(head2, step);
                ListNode[] merged = mergeTwoLists(head1,head2);
                newListTail.next = merged[0];
                newListTail = merged[1];
            }
        }
        return dummy.next;
    }

    private static ListNode[] mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        while (cur.next != null) {
            cur = cur.next;
        }
        return new ListNode[]{dummy.next, cur};
    }

    /**
     * 分割链表
     *
     * @param head
     * @param step
     * @return 剩余链表的头节点
     */
    private static ListNode splitList(ListNode head, int step) {
        ListNode cur = head;
        for (int i = 0; i < step - 1 && cur != null; i++) {
            cur = cur.next;
        }
        if (cur == null || cur.next == null) {
            return null;
        }
        ListNode next = cur.next;
        cur.next = null;
        return next;
    }

    private static int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    /**
     * 归并 自顶向下
     * 时间复杂度O(nlogn)
     * 空间复杂度O(logn)
     *
     * @param head
     * @return
     */
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 1. 找到中间的节点 断开连接
        ListNode head2 = findMiddle(head);
        // 2. 分别排序左边和右边
        head = sortList(head);
        head2 = sortList(head2);
        return merge(head, head2);
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        p.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        return next;
    }
}
