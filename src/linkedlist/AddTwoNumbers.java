package linkedlist;

import java.io.IOException;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int value1 = p == null ? 0 : p.val;
            int value2 = q == null ? 0 : q.val;
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }


    public static void main(String[] args) throws IOException {
        ListNode head1 = LinkedListIO.input();
        ListNode head2 = LinkedListIO.input();
        ListNode ans = addTwoNumbers(head1, head2);
        LinkedListIO.output(ans);
        LinkedListIO.destroy();
    }
}
