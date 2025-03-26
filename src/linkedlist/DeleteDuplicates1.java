package linkedlist;

import java.io.IOException;

public class DeleteDuplicates1 {

    public static void main(String[] args) throws IOException {
        ListNode head = LinkedListIO.input();
        deleteDuplicates(head);
        LinkedListIO.output(head);
        LinkedListIO.destroy();
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head, q = head.next;
        while (q != null) {
            while (q != null && p.val == q.val) {
                q = q.next;
            }
            p.next = q;
            p = p.next;
            if (q != null) q = q.next;
        }
        return head;
    }
}
