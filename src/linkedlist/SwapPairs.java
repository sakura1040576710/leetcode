package linkedlist;

import java.io.IOException;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {

    public static void main(String[] args) throws IOException {
        ListNode head = LinkedListIO.input();
        ListNode listNode = swapPairs(head);
        LinkedListIO.output(listNode);
        LinkedListIO.destroy();
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode start = pre.next, end = pre.next.next;
            pre.next = end;
            start.next = end.next;
            end.next = start;
            pre = start;
        }
        return dummy.next;
    }
}
