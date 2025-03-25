package LinkedList;

import java.io.IOException;

public class DeleteDuplicates2 {

    public static void main(String[] args) throws IOException {
        ListNode head = LinkedListIO.input();
        head = deleteDuplicates(head);
        LinkedListIO.output(head);
        LinkedListIO.destroy();
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode p = pre.next, q = p.next;
            if (p.val != q.val) {
                pre = pre.next;
                continue;
            }
            while (q != null && p.val == q.val) {
                p = p.next;
                q = q.next;
            }
            pre.next = q;
        }
        return dummy.next;
    }
}
