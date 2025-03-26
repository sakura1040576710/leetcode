package linkedlist;

import java.io.IOException;

/**
 * 142.环形链表2
 */
public class CycleLinkedList2 {

    private static ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) break;
        }
        if (fast==null||fast.next==null||fast!=slow) return null;
        ListNode p=head;
        while (p!=slow){
            p=p.next;
            slow=slow.next;
        }
        return p;
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
        ListNode ans = detectCycle(head);
        if (ans != null){
            LinkedListIO.bw.write(ans.val + "");
        }else{
            LinkedListIO.bw.write("null");
        }
        LinkedListIO.destroy();
    }
}
