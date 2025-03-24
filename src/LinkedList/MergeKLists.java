package LinkedList;

import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 合并k个升序链表
 */
public class MergeKLists {

    /**
     * 最小堆
     * 时间复杂度O(nlogk) n是所有链表的节点的和 k是lists长度
     * 空间复杂度O(k) k是堆中元素
     *
     * @param lists
     * @return
     */
    private static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }

    /**
     * 归并
     * 时间复杂度O(nlogk) n是所有链表的节点的和 k是lists长度
     * 空间复杂度O(logk) 递归深度
     *
     * @param lists
     * @return
     */
    private static ListNode mergeKLists2(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    private static ListNode partition(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        return merge(partition(lists, left, mid), partition(lists, mid + 1, right));
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode p = l1, q = l2;
        while (p != null && q != null) {
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
        ListNode[] lists = LinkedListIO.inputMulti();
//        ListNode listNode = mergeKLists(lists);
        ListNode listNode = mergeKLists2(lists);
        LinkedListIO.output(listNode);
        LinkedListIO.destroy();
    }
}
