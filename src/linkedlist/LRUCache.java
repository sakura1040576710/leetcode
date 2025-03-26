package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Node dummy;
    private Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy = new Node(-1,-1);
        dummy.next = dummy;
        dummy.prev = dummy;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        // 1. 根据key在map中查找 为null直接返回-1
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 2. 不为null则找到对应的节点 从链表中删除 并添加到头
        delete(node);
        front(node);
        // 3. 返回
        return node.val;
    }

    public void put(int key, int value) {
        // 1. 根据key在map中查找
        Node node = map.get(key);
        // 2. 为null则直接添加 并判断capacity是否超过 如果超过则删除最后一个
        if (node == null) {
            node = new Node(key,value);
            front(node);
            map.put(key, node);
            if (map.size()>capacity){
                Node last = dummy.prev;
                delete(last);
                map.remove(last.key);
            }
            return ;
        }
        // 3. 不为null则替换 并移动至头部
        node.val = value;
        delete(node);
        front(node);
    }

    private void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void front(Node node){
        node.next = dummy.next;
        dummy.next = node;
        node.next.prev = node;
        node.prev = dummy;
    }

    class Node{
        int key,val;
        Node next,prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
}
