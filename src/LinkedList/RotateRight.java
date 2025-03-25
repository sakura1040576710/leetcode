package LinkedList;

import java.io.IOException;

public class RotateRight {

    public static void main(String[] args) throws IOException {
        ListNode head = LinkedListIO.input();
        int k = Integer.parseInt(LinkedListIO.br.readLine());
        ListNode listNode = rotateRight(head, k);
        LinkedListIO.output(listNode);
        LinkedListIO.destroy();
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int length = 0;
        ListNode fast = dummy.next;
        while (fast != null) {
            fast = fast.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        fast = dummy;
        for (int i = 0;i < k && fast != null; i++){
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        fast.next = dummy.next;
        dummy.next = next;
        return dummy.next;
    }
}
