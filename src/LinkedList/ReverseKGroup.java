package LinkedList;

import java.io.IOException;
import java.util.List;

public class ReverseKGroup {

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, start = dummy.next;
        while (start != null) {
            ListNode end = start;
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            // 不足k个 则退出
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            start = pre.next;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
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
        int k = Integer.parseInt(LinkedListIO.br.readLine());
        head = reverseKGroup(head, k);
        LinkedListIO.output(head);
        LinkedListIO.destroy();
    }
}
