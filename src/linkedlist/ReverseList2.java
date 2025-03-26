package linkedlist;

import java.io.IOException;

public class ReverseList2 {

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode end = pre.next;
        for (int i = 0; i < right - left && end != null; i++) {
            end = end.next;
        }
        if (end == null) {
            return head;
        }
        ListNode next = end.next;
        end.next = null;
        ListNode start = pre.next;
        pre.next = reverse(start);
        start.next = next;
        return dummy.next;
    }

    private static ListNode reverse(ListNode head){
        ListNode dummy =new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) throws IOException {
        ListNode head = LinkedListIO.input();
        int left = Integer.parseInt(LinkedListIO.br.readLine());
        int right = Integer.parseInt(LinkedListIO.br.readLine());
        ListNode listNode = reverseBetween(head, left, right);
        LinkedListIO.output(listNode);
        LinkedListIO.destroy();
    }
}
