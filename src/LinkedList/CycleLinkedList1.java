package LinkedList;

import java.io.IOException;

/**
 * 141.环形链表
 */
public class CycleLinkedList1 {

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        ListNode head = LinkedListIO.input();
        Integer pos = Integer.parseInt(LinkedListIO.br.readLine());
        if (pos != -1) {
            ListNode p = head, q = head;
            for (int i = 0; i < pos && p != null; i++) {
                p = p.next;
            }
            while (q != null && q.next != null) {
                q = q.next;
            }
            q.next = p;
        }
//        LinkedListIO.output(head);
        boolean b = hasCycle(head);
        LinkedListIO.bw.write(b + "");
        LinkedListIO.destroy();
    }
}
