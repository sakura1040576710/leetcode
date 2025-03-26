package linkedlist;

import java.io.IOException;

public class Partition {
    public static void main(String[] args) throws IOException {
        ListNode head = LinkedListIO.input();
        int x = Integer.parseInt(LinkedListIO.br.readLine());
        ListNode listNode = partition(head, x);
        LinkedListIO.output(listNode);
        LinkedListIO.destroy();
    }

    private static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p = dummy1, q = dummy2;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = dummy2.next;
        return dummy1.next;
    }
}
