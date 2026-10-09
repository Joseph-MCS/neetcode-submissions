public class ListNode
{

    int val, key;
    ListNode prev, next;

    public ListNode( int val )
    {
        this.val = val;
    }

    public ListNode( int key, int val )
    {
        this.key = key;
        this.val = val;
    }

    public ListNode( int key, int val, ListNode prev, ListNode next )
    {
        this.key = key;
        this.val = val;
        this.prev = prev; 
        this.next = next;
    }
    

}

class LRUCache {

    int capacity; 
    int size; 
    HashMap<Integer, ListNode> cache;
    ListNode head; 
    ListNode tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.size = 0; 
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        cache = new HashMap<>();
        head.prev = tail;
        tail.next = head;
    }
    
    public int get(int key) {

        if ( !(cache.containsKey(key)) ) return -1;
        else
        {

        ListNode node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;
        }
        
    }
    
    public void put(int key, int value) {

        if ( cache.containsKey(key ))
        {
            ListNode existing = cache.get(key);
            remove(existing);
            existing.val=value;
            insert(existing);
            return;
        }

        ListNode newNode = new ListNode(key,value);
        cache.put( key, newNode );
        insert(  newNode );
        if ( capacity < cache.size() )
        {

            remove( tail.next );

        }
        
    }

    public void remove( ListNode node )
    {

        cache.remove(node.key);
        ListNode succ = node.next;
        ListNode pred = node.prev;
        succ.prev = pred;
        pred.next = succ;
        size--;

    }

    public void insert( ListNode node )
    {
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        size++;
        cache.put(node.key, node);
    }

}
