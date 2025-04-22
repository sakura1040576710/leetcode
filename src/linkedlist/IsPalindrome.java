package linkedlist;

import java.io.IOException;

public class IsPalindrome {

    public static void main(String[] args) throws IOException {
        ListNode head = LinkedListIO.input();
        boolean res = isPalindrome(head);
        LinkedListIO.bw.write(res + "");
        LinkedListIO.destroy();
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        ListNode p = head, q = head2;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }


}
