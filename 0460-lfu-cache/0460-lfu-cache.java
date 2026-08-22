class LFUCache {

    int capacity;
    int minFrequency;
    int curSize;
    Map<Integer,Node> cache;
    Map<Integer,DoublyLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFrequency = 0;
        curSize = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        Node curNode = cache.get(key);
        updateNode(curNode);

        return curNode.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
        }
        else {
            //new node came which is not in cache or frequencyMap
            curSize++;
            if(curSize > capacity) {
                DoublyLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }

            minFrequency = 1;
            Node newNode = new Node(key,value);

            DoublyLinkedList curList = frequencyMap.getOrDefault(1,new DoublyLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1,curList);
            cache.put(key,newNode);
        }
    }

    public void updateNode(Node curNode) {
        int curFreq = curNode.freq;
        DoublyLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        if(curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }

        curNode.freq++;

        DoublyLinkedList newList = frequencyMap.getOrDefault(curNode.freq,new DoublyLinkedList());

        newList.addNode(curNode);
        frequencyMap.put(curNode.freq,newList);

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 class Node {
    int key;
    int value;
    int freq;
    Node prev;
    Node next;

    public Node(int key,int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
        this.prev = null;
        this.next = null;
    }
 }

 class DoublyLinkedList {
    Node head;
    Node tail;
    int listSize;

    public DoublyLinkedList() {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.listSize = 0;
    }

    public void addNode(Node newNode) {
        Node nextNode = head.next;
        newNode.next = nextNode;
        newNode.prev = head;
        head.next = newNode;
        nextNode.prev = newNode;

        listSize++;//As new node is inserted the doubly linked list size will increases by 1
    }

    public void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        listSize--;
    }
 }