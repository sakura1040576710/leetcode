package linkedlist;

public class RemoveNthFromEnd {

    public static void main(String[] args) throws Exception {
        ListNode head = LinkedListIO.input();
        int n = Integer.parseInt(LinkedListIO.br.readLine());
        head = removeNthFromEnd(head, n);
        LinkedListIO.output(head);
        LinkedListIO.destroy();
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
