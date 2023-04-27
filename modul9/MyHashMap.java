package ua.goit.sergey.modul9;


public class MyHashMap< K, V >  {

    private Node[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    static class Node < K, V >{
        K key ;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        buckets = new Node[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value, buckets[index]);
        buckets[index] = newNode;
        size++;
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node node = buckets[index];
        Node prevNode = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prevNode == null) {
                    buckets[index] = node.next;
                } else {
                    prevNode.next = node.next;
                }
                size--;
                return;
            }
            prevNode = node;
            node = node.next;
        }
    }

    public void clear() {
        buckets = new Node[buckets.length];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(K key) {
        int index = getIndex(key);
        Node node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % buckets.length;
    }
}

