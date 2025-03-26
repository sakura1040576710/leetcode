package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 154. 复杂链表的复制
 * 实际上就是链表的深拷贝
 * 保证得到的结果和原链表的地址是不一样的
 */
public class CopyRandomList {

    static class Node {
        int val;
        Node next, random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public static void main(String[] args) throws Exception {
        String s = LinkedListIO.br.readLine();
        s = s.substring(2, s.length() - 2);
        String[] strings = s.split("],\\[");
        Node head = new Node(-1);
        Node p = head;
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String[] str = strings[i].split(",");
            int val = Integer.parseInt(str[0]);
            Node cur = new Node(val);
            String random = str[1];
            if (!"null".equals(random)) {
                cur.random = map.get(Integer.parseInt(random));
            }
            map.put(i, cur);
            p.next = cur;
            p = p.next;
        }
//        Node node = copyRandomList(head.next);
        Node node = copyRandomList2(head.next);
        for (Node cur = node; cur != null; cur = cur.next) {
            LinkedListIO.bw.write(cur.val + " ");
        }
        LinkedListIO.destroy();
    }

    private static Node copyRandomList2(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newNode = map.get(cur);
            if (cur.next != null) {
                newNode.next = map.get(cur.next);
            }
            if (cur.random != null) {
                newNode.random = map.get(cur.random);
            }
        }
        return map.get(head);
    }

    private static Node copyRandomList(Node head) {
        if (head == null) return null;
        // 将每一个节点复制一个新的节点 作为它的下一个节点
        for (Node node = head; node != null; node = node.next) {
            Node next = node.next;
            node.next = new Node(node.val);
            node = node.next;
            node.next = next;
        }
        // 重新调整random的指向
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                // 新节点的random是原来节点的random的下一个
                node.next.random = node.random.next;
            }
        }
        Node newHead = head.next;
        Node cur = head;
        for (; cur.next.next != null; cur = cur.next) {
            Node copy = cur.next;
            cur.next = copy.next;  // 恢复原节点的next
            copy.next = cur.next.next;
        }
        cur.next = null;
        return newHead;
    }
}
