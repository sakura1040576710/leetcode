package LinkedList;

import java.io.IOException;

public class GetIntersectionNode {

    public static void main(String[] args) throws IOException {
        ListNode headA = LinkedListIO.input();
        ListNode headB = LinkedListIO.input();
        ListNode listNode = getIntersectionNode(headA, headB);
        LinkedListIO.output(listNode);
        LinkedListIO.destroy();
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p.next == null ? headB : p.next;
            q = q.next == null ? headA : q.next;
        }
        return p;
    }
}
