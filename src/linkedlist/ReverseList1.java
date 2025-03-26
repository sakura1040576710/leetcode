package linkedlist;

import java.io.IOException;

public class ReverseList1 {

    private static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) throws IOException {
        ListNode head = LinkedListIO.input();
        ListNode reverseList = reverseList(head);
        LinkedListIO.output(reverseList);
        LinkedListIO.destroy();
    }
}
