package LinkedList;

import java.io.IOException;

/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode p = list1, q = list2;
        while (p != null && q != null){
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        cur.next = p == null ? q : p;
        return dummy.next;
    }

    public static void main(String[] args) throws IOException {
        ListNode head1 = LinkedListIO.input();
        ListNode head2 = LinkedListIO.input();
        ListNode ans = mergeTwoLists(head1, head2);
        LinkedListIO.output(ans);
        LinkedListIO.destroy();
    }
}
