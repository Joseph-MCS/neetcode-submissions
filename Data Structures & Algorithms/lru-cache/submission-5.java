class ListNode
{
    int key;
    int val;
    ListNode next; 
    ListNode prev;

    public ListNode( int key, int val )
    {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    int capacity;
    ListNode head;
    ListNode tail; 
    HashMap< Integer, ListNode > cache; 

    public LRUCache(int capacity) {

        this.capacity = capacity; 
        this.head = new ListNode(-1,0); // dummy sentinel nodes
        this.tail = new ListNode(-1,0); // dummy sentinel nodes
        head.prev = tail; 
        tail.next = head;
        cache = new HashMap<>();
        
    }
    
    public int get(int key) {

        if ( !cache.containsKey(key)) return -1; 
        else 
        {

            ListNode node = cache.get(key);
            int val = node.val;
            remove(node);
            insert(node);
            return val;

        }
        
    }

    public void remove( ListNode node )
    {

        ListNode succ = node.next;
        ListNode pred = node.prev;
        pred.next = succ;
        succ.prev = pred;

    }

    public void insert( ListNode node )
    {

        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;

    }
    
    public void put(int key, int value) 
    {

        ListNode node = new ListNode(key,value);
        if ( cache.containsKey( key ) )
        {
            ListNode prev = cache.get(key);
            remove(prev);
            cache.remove(key);

        }
        insert(node);
        cache.put(key,node);

        if ( cache.size() > capacity )
        {
            cache.remove( tail.next.key );
            remove( tail.next );
        }
        
        
    }
}
