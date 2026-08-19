class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key,int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public void insertAfterHead(Node newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }

    public void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

}
class LRUCache {
    int capacity;
    HashMap<Integer,Node> map;
    DoublyLinkedList dl;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dl = new DoublyLinkedList();
    }
    
    public int get(int key) {

        if(!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        dl.deleteNode(node);
        dl.insertAfterHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            dl.deleteNode(node);
            dl.insertAfterHead(node);
            return;
        }

        if(map.size() >= capacity) {
            Node node = dl.tail.prev;
            dl.deleteNode(node);
            map.remove(node.key);
            Node newNode = new Node(key,value);
            dl.insertAfterHead(newNode);
            map.put(key,newNode);
            return;
        }
        else {
            Node newNode = new Node(key,value);
            dl.insertAfterHead(newNode);
            map.put(key,newNode);

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */