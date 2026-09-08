public class ListNode{
    int key, val; 
    ListNode next,prev; 

    public ListNode(int key, int val)
    {
        this.key = key;
        this.val = val; 
    }
    public ListNode(int key, int val, ListNode prev, ListNode next )
    {
        this.val = val;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {

    ListNode head; // the least recently used 
    ListNode tail; // the most recently used
    HashMap<Integer, ListNode> cache; 
    int capacity; 

    public LRUCache(int capacity) {

        this.head = new ListNode(0,0);
        this.tail = new ListNode(0,0);
        this.capacity = capacity; 
        this.cache = new HashMap<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        
    }

    private void remove(ListNode node)
    {
        ListNode pred = node.prev;
        ListNode succ = node.next; 
        pred.next = succ; 
        succ.prev = pred;

    }

    private void insert(ListNode node)
    {    
        ListNode newNode = node; 
        newNode.prev = this.tail.prev; 
        newNode.next = this.tail; 
        this.tail.prev.next = newNode; 
        this.tail.prev = newNode;
    }
    
    public int get(int key) 
    {
        if ( (cache.containsKey(key)) ) 
        {
            ListNode node = cache.get(key); 
            remove(node);
            insert(node);
            return node.val;
        }
        else return -1; 
    }
    
    public void put(int key, int value) 
    {
        if ( cache.containsKey(key) )
        {
            remove(cache.get(key));
        }

        ListNode newNode = new ListNode(key,value);
        cache.put(key,newNode);
        insert(newNode);

        if ( cache.size() > capacity )
        {
           ListNode leastRecentNode = this.head.next; 
           remove(leastRecentNode);
           cache.remove(leastRecentNode.key);
        }
        
    }
}
