package data_structure.Cache.LRU;

import java.util.HashMap;

public class LRUCache {
    // https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/

    public static void main(String[] args) {

        System.out.println("Going to test the LRU Cache Implementation");
        LRUCache cache = new LRUCache(2);

        // it will store a key (1) with value 10 in the cache.
        cache.set(1, 10);

        // it will store a key (1) with value 10 in the cache.
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

        // evicts key 2 and store a key (3) with value 30 in the cache.
        cache.set(3, 30);
        System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found)

        // evicts key 1 and store a key (4) with value 40 in the cache.
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40
    }

    static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private int count;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        head.pre = null;

        tail.pre = head;
        tail.next = null;

        count = 0;
    }

    public void deleteNode(Node node) {
        // 함수 파라미터 node 옆을 바로 연결해준다.
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        // head 다음으로 node를 추가

        // 기존의 첫번째를 신규 node의 뒤로 만들다.
        node.next = head.next;
        node.next.pre = node;

        // head와도 연결해준다.
        node.pre = head;
        head.next = node;
    }

    // This method works in O(1)
    public int get(int key) {

        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;

            deleteNode(node);
            addToHead(node);

            System.out.println("Got the value : " + result + " for the key: " + key);
            return result;
        }

        System.out.println("Did not get any value" + " for the key: " + key);
        return -1;
    }

    // This method works in O(1)
    public void set(int key, int value) {
        System.out.println("Going to set the (key, value) : (" + key + ", " + value + ")");

        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);

        } else {
            Node node = new Node(key, value);
            map.put(key, node);

            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}
